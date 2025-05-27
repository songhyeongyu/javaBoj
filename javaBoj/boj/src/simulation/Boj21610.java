package simulation;

import java.io.*;
import java.util.*;

class Boj21610 {

    static int N;
    static int M;

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] odd = {1, 3, 5, 7};

    static int[][] board;
    public static void main(String[] args) throws IOException {
        Boj21610 process = new Boj21610();
        process.run();
    }

    private void run() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(N - 1, 0));
        que.offer(new Node(N - 1, 1));
        que.offer(new Node(N - 2, 0));
        que.offer(new Node(N - 2, 1));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //시작
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            boolean[][] cloud = new boolean[N][N];
            int d = Integer.parseInt(st.nextToken());
            d -= 1;
            int s = Integer.parseInt(st.nextToken());

            Queue<Node> temp = new LinkedList<>();
            while (!que.isEmpty()) {
                Node cur = que.poll();

                int nx = cur.x + (dx[d] * s);
                int ny = cur.y + (dy[d] * s);
                nx = ((nx % N) + N) % N;
                ny = ((ny % N) + N) % N;
                cloud[nx][ny] = true;
                board[nx][ny] += 1;

                temp.offer(new Node(nx, ny));
            }
            while (!temp.isEmpty()) {
                Node cur = temp.poll();

                for (int o : odd) {
                    int nx = cur.x + dx[o];
                    int ny = cur.y + dy[o];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }
                    if (board[nx][ny] > 0) {
                        board[cur.x][cur.y] += 1;
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!cloud[j][k] && board[j][k] >= 2) {
                        board[j][k] -= 2;
                        que.offer(new Node(j, k));
                    }
                }
            }


        }

        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += board[i][j];
            }
        }

        System.out.println(sum);

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