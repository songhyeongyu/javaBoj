package simulation;

import java.util.*;
import java.io.*;

public class Boj15683 {
    static int N;
    static int M;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] board;

    static int[][][] dir = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 1}, {2, 3}},
            {{0, 2}, {0, 3}, {1, 2}, {1, 3}},
            {{0, 1, 2}, {0, 2, 3}, {3, 0, 1}, {1, 2, 3}},
            {{0, 1, 2, 3}}
    };

    static int minValue = Integer.MAX_VALUE;
    static List<Node> cctv = new ArrayList<>();



    public static void main(String[] args) throws IOException{
        Boj15683 process = new Boj15683();
        process.run();
    }

    private void run() throws IOException {
        init();
        recur(0);
        System.out.println(minValue);
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > 0 && num < 6) {
                    cctv.add(new Node(i, j, num));
                }
                board[i][j] = num;
            }
        }
    }

    private void recur(int index) {
        if (index == cctv.size()) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 0) {
                        count++;
                    }
                }
            }
            minValue = Math.min(count, minValue);
            return;
        }

        Node cur = cctv.get(index);

        int[][] direction = dir[cur.num];

        for (int[] d : direction) {
            List<Node> temp = new ArrayList<>();
            checkCctv(d,cur.x, cur.y, cur.num, temp);
            recur(index + 1);
            for (Node n : temp) {
                board[n.x][n.y] = 0;
            }
        }
    }

    private void checkCctv(int[] dir, int x, int y, int num, List<Node> temp) {
        for (int d : dir) {
            int nx = x;
            int ny = y;
            board[nx][ny] = num;
            while (true) {
                nx += dx[d];
                ny += dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    break;
                }
                if (board[nx][ny] == 6) {
                    break;
                }
                if (board[nx][ny] == 0) {
                    board[nx][ny] = num;
                    temp.add(new Node(nx, ny, num));
                }

            }
        }
    }

    static class Node{
        int x;
        int y;
        int num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
