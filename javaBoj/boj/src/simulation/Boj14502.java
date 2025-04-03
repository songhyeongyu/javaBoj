package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj14502 {
    static int N;
    static int M;
    static int zeroCnt;
    static int[][] temp;
    static int[][] board;
    static int maxValue = Integer.MIN_VALUE;
    static Queue<Node> virus;
    public static void main(String[] args) throws IOException{
        Boj14502 process = new Boj14502();
        process.run();
    }

    private void run() throws IOException {
        init();
        recur(0,0);
        System.out.println(maxValue);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        temp = new int[3][2];
        virus = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    zeroCnt++;
                }
                if (num == 2) {
                    virus.offer(new Node(i, j));
                }
                board[i][j] = num;
            }
        }
    }

    private void recur(int cur,int stI) {
        if (cur == 3) {
            for (int[] t : temp) {
                board[t[0]][t[1]] = 1;
            }
            boolean[][] visited = new boolean[N][M];
            Queue<Node> copyVirus = new LinkedList<>(virus);
            for (Node node : virus) {
                visited[node.x][node.y] = true;
            }
            int count = bfs(copyVirus , visited);
            for (int[] t : temp) {
                board[t[0]][t[1]] = 0;
            }
            maxValue = Math.max(maxValue, zeroCnt - count - 3);
            return;
        }

        for (int i = stI; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    temp[cur][0] = i;
                    temp[cur][1] = j;
                    recur(cur + 1,i);
                }
            }
        }
    }

    private int bfs(Queue<Node> copyVirus,boolean[][] visited) {
        int count = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!copyVirus.isEmpty()) {
            Node cur = copyVirus.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (board[nx][ny] == 1 || visited[nx][ny]) {
                    continue;
                }

                copyVirus.offer(new Node(nx, ny));
                visited[nx][ny] = true;
                count++;
            }
        }
        return count;
    }


    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
