package bfs;

import java.util.*;
import java.io.*;

public class Boj14442 {
    static int N;
    static int M;
    static int K;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static char[][] board;
    static int[][][] dist;



    public static void main(String[] args) throws IOException{
        Boj14442 process = new Boj14442();
        process.run();
    }

    private void run() throws IOException {
        init();
        System.out.println(bfs());
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        dist = new int[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
                for (int k = 0; k <= K; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }
    }

    private int bfs() {
        Queue<Node> que = new LinkedList<>();
        dist[0][0][0] = 1;
        que.offer(new Node(0, 0, 0));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int nxtDist = dist[cur.x][cur.y][cur.broken] + 1;

            if (cur.x == N - 1 && cur.y == M - 1) {
                return dist[cur.x][cur.y][cur.broken];
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (dist[nx][ny][cur.broken] == -1 && board[nx][ny] == '0') {
                    dist[nx][ny][cur.broken] = nxtDist;
                    que.offer(new Node(nx, ny, cur.broken));
                }

                if (cur.broken < K && dist[nx][ny][cur.broken+1] == -1 && board[nx][ny] == '1') {
                    dist[nx][ny][cur.broken + 1] = nxtDist;
                    que.offer(new Node(nx, ny, cur.broken + 1));
                }
            }
        }
        return -1;
    }


    static class Node{
        int x;
        int y;
        int broken;

        public Node(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }

}
