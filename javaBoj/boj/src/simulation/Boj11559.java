package simulation;

import org.w3c.dom.Node;

import java.util.*;
import java.io.*;


public class Boj11559 {
    static char[][] board;
    static int total;
    static int now;

    public static void main(String[] args) throws IOException{
        Boj11559 process = new Boj11559();
        process.run();
    }

    private void run() throws IOException {
        init();
        while (true) {
            boolean explosion = findExplosion();
            if(!explosion){
                break;
            }
            moveDown();
            total++;
        }
        System.out.println(total);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        board = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String input = bf.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = input.charAt(j);
            }
        }
    }

    private boolean findExplosion() {
        boolean[][] visit = new boolean[12][6];
        boolean flag = false;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != '.') {
                    List<Node> group = explorePuyo(i, j, visit);
                    if (group.size() >= 4) {
                        Puyo2Dot(group);
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    private List<Node> explorePuyo(int x, int y,boolean[][] visit) {
        Queue<Node> que = new LinkedList<>();
        List<Node> transDot = new ArrayList<>();

        que.add(new Node(x, y));
        transDot.add(new Node(x, y));
        visit[x][y] = true;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!que.isEmpty()) {
            Node cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) {
                    continue;
                }

                if ('.' == board[nx][ny] || visit[nx][ny]) {
                    continue;
                }
                if (board[cur.x][cur.y] != board[nx][ny]) {
                    continue;
                }

                que.offer(new Node(nx, ny));
                visit[nx][ny] = true;
                transDot.add(new Node(nx, ny));
            }
        }

        return transDot;
    }

    private void Puyo2Dot(List<Node> transDot) {
        for (int i = 0; i < transDot.size(); i++) {
            board[transDot.get(i).x][transDot.get(i).y] = '.';
        }
    }

    private void moveDown() {
        for (int i = 10; i > -1; i--) {
            for (int j = 5; j > -1; j--) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (board[i+1][j] == '.') {
                    int index = i;
                    char puyo = board[i][j];
                    while (true) {
                        index += 1;
                        if (index >=12 || board[index][j] != '.') {
                            break;
                        }
                        board[index][j] = puyo;
                        board[index-1][j] = '.';
                    }
                }
            }
        }
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
