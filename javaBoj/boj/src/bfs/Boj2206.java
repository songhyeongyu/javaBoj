package bfs;

import java.util.*;
import java.io.*;

public class Boj2206 {
    static int N;
    static int M;

    static char[][] board;
    static int[][][] dist;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        Boj2206 process = new Boj2206();
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

        board = new char[N][M];
        dist = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
                dist[i][j][0] = -1;
                dist[i][j][1] = -1;
            }
        }
    }


    private int bfs() {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0, 0,0));
        dist[0][0][0] = dist[0][0][1] = 1;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            int nextDist = dist[cur.x][cur.y][cur.broken] + 1;

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
                    dist[nx][ny][cur.broken] = nextDist;
                    que.offer(new Node(nx, ny, cur.broken));
                }

                if (dist[nx][ny][cur.broken] == -1 && board[nx][ny] == '1' && cur.broken == 0) {
                    dist[nx][ny][1] = nextDist;
                    que.offer(new Node(nx, ny, 1));
                }
            }

        }
        return -1;

    }

    static class Node{
        int x;
        int y;
        int broken;

        public Node(int x, int y,int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }
}
