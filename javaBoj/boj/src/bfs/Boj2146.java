package bfs;

import java.util.*;
import java.io.*;


public class Boj2146 {
    static int N;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int[][] dist;
    static Deque<Node> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        Boj2146 process = new Boj2146();
        process.run();
    }

    private void run() throws IOException{
        init();
        findIslandNum();
        findAnotherLand();

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }

    }
    
    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        board = new int[N][N];
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
        
    }

    private void findIslandNum() {
        int idx = 1;
        boolean[][] isVisit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] != 0 && !isVisit[i][j]){
                    bfs(i, j, idx,isVisit);
                    idx++;
                }
            }
        }

    }

    private void bfs(int x, int y,int idx, boolean[][] isVisit) {
        Deque<Node> island = new LinkedList<>();


        board[x][y] = idx;
        dist[x][y] = 0;
        island.offer(new Node(x, y, idx));
        isVisit[x][y] = true;

        while (!island.isEmpty()) {
            Node cur = island.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (board[nx][ny] == 0 || isVisit[nx][ny]) {
                    continue;
                }

                board[nx][ny] = idx;
                isVisit[nx][ny] = true;
                island.offer(new Node(nx, ny, idx));
                dq.offer(new Node(nx, ny, idx));
                dist[nx][ny] = 0;
            }
        }
    }

    private void findAnotherLand() {

        int ans = Integer.MAX_VALUE;
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (board[nx][ny] != 0 && cur.islandNumber != board[nx][ny]) {
                    ans = Math.min(ans, dist[cur.x][cur.y]);
                    continue;
                }

                if(dist[nx][ny] == -1 && board[nx][ny] == 0) {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    dq.offer(new Node(nx, ny, cur.islandNumber));
                }
            }

        }
        System.out.println(ans);
    }


    static class Node {
        int x;
        int y;
        int islandNumber;

        public Node(int x, int y, int islandNumber) {
            this.x = x;
            this.y = y;
            this.islandNumber = islandNumber;
        }
    }

}
