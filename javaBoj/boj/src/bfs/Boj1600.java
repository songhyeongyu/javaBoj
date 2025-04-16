package bfs;

import java.util.*;
import java.io.*;

public class Boj1600 {
    static int T;
    static int N;
    static int M;
    static char[][] board;
    static int[][][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    static int[] dxH = {2, 1, -1, -2, -2, -1, 2, 1};
    static int[] dyH = {1, 2, 2, 1, -1, -2, -1, -2};

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Boj1600 process = new Boj1600();
        process.run();
    }

    private void run() throws IOException {
        init();
        System.out.println(makeDistance());
//        printDist();

    }

    private void init() throws IOException {
        T = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        dist = new int[N][M][T+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = st.nextToken().charAt(0);
                for (int k = 0; k <= T; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }
    }

    private int makeDistance() {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0, 0, 0));
        dist[0][0][0] = 0;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int nextDist = dist[cur.x][cur.y][cur.jump] + 1;

            //1. 원숭이 점프
            if (cur.x == N - 1 && cur.y == M - 1) {
                return dist[cur.x][cur.y][cur.jump];
            }

            if(cur.jump+1 <= T){
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + dxH[i];
                    int ny = cur.y + dyH[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (board[nx][ny] == '1' || dist[nx][ny][cur.jump + 1] != -1) {
                        continue;
                    }
                    dist[nx][ny][cur.jump + 1] = nextDist;
                    que.offer(new Node(nx, ny, cur.jump + 1));
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (board[nx][ny] == '1' || dist[nx][ny][cur.jump] != -1) {
                    continue;
                }
                dist[nx][ny][cur.jump] = nextDist;
                que.offer(new Node(nx, ny, cur.jump));
            }


        }
        return -1;
    }

    private void printDist() {
        for (int k = 0; k <= T; k++) {
            System.out.println("Jump Level: " + k);
            for (int i = 0; i < N; i++) {
                int[] row = new int[M];
                for (int j = 0; j < M; j++) {
                    row[j] = dist[i][j][k];
                }
                System.out.println(Arrays.toString(row));
            }
            System.out.println("-".repeat(30));
        }
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
