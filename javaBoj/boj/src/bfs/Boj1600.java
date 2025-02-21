package bfs;

import java.io.*;
import java.util.*;

public class Boj1600 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] horseDx = {2, 2, 1, -1, -2, -2, 1, -1};
    static int[] horseDy = {1, -1, 2, 2, 1, -1, -2, -2};

    static char[][] board;
    static int[][][] dist;
    static boolean[][][] visited;

    static int K;
    static int N;
    static int M;

    static Deque<Node> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        Boj1600 process = new Boj1600();
        process.run();

    }

    private void run() throws IOException{
        init();
        bfs();
//        System.out.println(dist[N-1][M-1][0]);
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        dist = new int[N][M][K+1];
        visited = new boolean[N][M][K+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                char c = st.nextToken().charAt(0);
                board[i][j] = c;
            }
        }
        for (int k = 0; k < K + 1; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    dist[i][j][k] = -1;
                }
            }
        }

    }

    private void bfs() {
        Deque<Node> dq = new LinkedList<>();
        dq.offer(new Node(0, 0, K));
        dist[0][0][K] = 0;
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();

            if (cur.x == N - 1 && cur.y == M - 1) {
                System.out.println(dist[cur.x][cur.y][cur.year]);
                return;
            }


            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (board[nx][ny] == 1||dist[nx][ny][cur.year] > 0) {
                    continue;
                }

                dist[nx][ny][cur.year] = dist[cur.x][cur.y][cur.year] + 1;
                dq.offer(new Node(nx, ny, cur.year));
            }

            if (cur.year > 0) {

                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + horseDx[i];
                    int ny = cur.y + horseDy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (board[nx][ny] == 1 || dist[nx][ny][cur.year] > 0) {
                        continue;
                    }

                    dist[nx][ny][cur.year - 1] = dist[nx][ny][cur.year];
                    dq.offer(new Node(nx, ny, cur.year - 1));
                }
            }
        }
    }




    static class Node{
        int x;
        int y;
        int year;

        public Node(int x, int y, int year) {
            this.x = x;
            this.y = y;
            this.year = year;
        }
    }
}
