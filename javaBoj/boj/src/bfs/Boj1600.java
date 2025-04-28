package bfs;

import java.util.*;
import java.io.*;

public class Boj1600 {
    static int K;
    static int N;
    static int M;
    static int[][] board;
    static int[][][] dist;


    static int[] Hdx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] Hdy = {1, 2, 2, 1, -1, -2, -2, -1};

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        Boj1600 process = new Boj1600();
        process.run();
    }

    private void run() throws IOException {
        init();
        System.out.println(bfs());
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dist = new int[N][M][K+1];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k <= K; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }

    }

    private int bfs() {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0, 0, 0));
        dist[0][0][0] = 0;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int nxt = dist[cur.x][cur.y][cur.jump] + 1;

            if (cur.x == N - 1 && cur.y == M - 1) {
                return dist[cur.x][cur.y][cur.jump];
            }

            if (cur.jump < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + Hdx[i];
                    int ny = cur.y + Hdy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (dist[nx][ny][cur.jump + 1] != -1 || board[nx][ny] == 1) {
                        continue;
                    }
                    int nxtJump = cur.jump + 1;
                    dist[nx][ny][nxtJump] = nxt;
                    que.offer(new Node(nx, ny, nxtJump));
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (dist[nx][ny][cur.jump] != -1 || board[nx][ny] == 1) {
                    continue;
                }

                dist[nx][ny][cur.jump] = nxt;
                que.offer(new Node(nx, ny, cur.jump));

            }


        }

        return -1;
    }

    static class Node{
        int x;
        int y;
        int jump;

        public Node(int x, int y, int jump) {
            this.x = x;
            this.y = y;
            this.jump = jump;
        }
    }
}
