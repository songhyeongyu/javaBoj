package bfs;

import java.util.*;
import java.io.*;

public class Boj2573 {
    static int N;
    static int M;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] board;
    static List<Node> ice = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Boj2573 process = new Boj2573();
        process.run();
    }

    private void run() throws IOException {
        init();
        calculateIce();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if (num > 0) {
                    ice.add(new Node(i, j, num));
                }
            }
        }
    }

    private void calculateIce() {
        int index = 0;
        while (true) {
            int size = ice.size();
            index++;
            List<Node> chk = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (ice.get(i).year <= 0) {
                    continue;
                }
                int cnt = checkIce(ice.get(i).x, ice.get(i).y);
                ice.get(i).year -= cnt;
                if (ice.get(i).year < 0) {
                    ice.get(i).year = 0;
                }
                chk.add(new Node(ice.get(i).x, ice.get(i).y, ice.get(i).year));
            }

            ice = new ArrayList<>(chk);

            for (int i = 0; i < ice.size(); i++) {
                board[ice.get(i).x][ice.get(i).y] = ice.get(i).year;
            }


//            System.out.println("Year: " + index);
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(board[i]));
//            }
//
//            System.out.println("-".repeat(30));
            int count = 0;
            boolean[][] visited = new boolean[N][M];
            int sumValue = 0;
            for (int i = 0; i < N; i++) {
                sumValue += Arrays.stream(board[i]).sum();
                for (int j = 0; j < M; j++) {
                    if (board[i][j] != 0 && !visited[i][j]) {
                        bfs(i, j,visited);
                        count++;
                    }
                }
            }

            if (count > 1) {
                System.out.println(index);
                break;
            }
            if (count == 0 && sumValue == 0) {
                System.out.println(0);
                break;
            }

        }
    }

    private void bfs(int x, int y, boolean[][] visited) {
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(x, y));
        visited[x][y] = true;
        while (!que.isEmpty()) {
            Pair cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (visited[nx][ny] || board[nx][ny] == 0) {
                    continue;
                }
                que.offer(new Pair(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    private int checkIce(int x, int y) {
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(x, y));
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if (board[nx][ny] == 0) {
                count++;
            }
        }
        return count;
    }

    // 덩어리 추적


    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node {
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
