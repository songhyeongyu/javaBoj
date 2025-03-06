package bfs;

import java.io.*;
import java.util.*;

public class Boj1600 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[] dxH = {2, 1, -1, -2, -2, -1, 1, -2};
    static int[] dyH = {1, 2, 2, 1, -1, -2, -2, -1};

    static int k;
    static int r;
    static int c;

    static int[][] board;
    static int[][][] dist;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        Boj1600 process = new Boj1600();
        process.run();
    }

    private void run() throws IOException {
        init();
        bfs(0, 0);

    }
    /*2
10 2
0 0 1 0 0 1 0 0 1 0
0 0 1 1 0 0 0 0 1 0*/
    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        dist = new int[32][r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dist[0][i][j] = -1;
            }
        }

        for (int z = 0; z <= k; z++) {
            for (int i = 0; i < r; i++) {
                Arrays.fill(dist[z][i], -1);
            }
        }

    }

    private void bfs(int x, int y) {
        queue.offer(new Node(x, y,0));
        dist[0][x][y] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();


            if (cur.cnt < k) {
                BfsHorse(cur);
            }

            BfsMonkey(cur);
        }


    }

    private int BfsHorse(Node cur) {
        for (int i = 0; i < 8; i++) {
            int nx = cur.x + dxH[i];
            int ny = cur.y + dyH[i];

            if (nx == r - 1 && ny == c - 1) {
                return dist[cur.cnt][cur.x][cur.y] + 1;
            }

            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }

            if (board[nx][ny] == 1 || dist[cur.cnt + 1][nx][ny] != -1) {
                continue;
            }

            dist[cur.cnt + 1][nx][ny] = dist[cur.cnt][cur.x][cur.y] + 1;
            queue.offer(new Node(nx, ny, cur.cnt+1));

        }
        return 0;
    }

    private void BfsMonkey(Node cur) {
        for (int i = 0; i < 4; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];

            if (nx == r - 1 && ny == c - 1) {
                System.out.println(dist[cur.cnt][cur.x][cur.y] + 1);
                System.exit(0);
            }

            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }
            if (board[nx][ny] == 1 || dist[cur.cnt][nx][ny] != -1) {
                continue;
            }
            queue.offer(new Node(nx, ny, cur.cnt));
            dist[cur.cnt][nx][ny] = dist[cur.cnt][cur.x][cur.y] + 1;
        }
    }


    static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }
}
