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

    static Deque<Node> deque = new LinkedList<>();


    public static void main(String[] args) throws IOException{
        Boj2206 process = new Boj2206();
        process.run();
    }

    private void run() throws IOException{
        init();
        System.out.println(bfs());
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        dist = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                board[i][j] = c;
                dist[i][j][0] = -1;
                dist[i][j][1] = -1;
            }
        }
    }

    private int bfs() {
        deque.offer(new Node(0, 0, 0));
        dist[0][0][0] = dist[0][0][1] = 0;


        while (!deque.isEmpty()) {
            Node cur = deque.pollFirst();
            if (cur.x == N - 1 && cur.y == M - 1) {
                return dist[cur.x][cur.y][cur.broken];
            }

            int nxt = dist[cur.x][cur.y][cur.broken] + 1;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                //벽이 안부서진 경우
                if (board[nx][ny] == '0' && dist[nx][ny][cur.broken] == -1) {
                    dist[nx][ny][cur.broken] = nxt;
                    deque.offer(new Node(nx, ny, cur.broken));
                }

                //벽을 부순 경우
                if (cur.broken != 1 && board[nx][ny] == '1' && dist[nx][ny][cur.broken] == -1) {
                    dist[nx][ny][1] = nxt;
                    deque.offer(new Node(nx, ny, 1));
                }
            }
        }
        return -1;
    }

    static class Node {
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
