package bfs;

import java.util.*;
import java.io.*;

public class Boj2573 {
    static int N;
    static int M;

    static int[][] ice;
    static int[][] visited;
    static boolean[][] isIce;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Deque<Node> deque = new LinkedList<>();
    static Deque<Node> meltingICe = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Boj2573 process = new Boj2573();
        process.run();
    }

    private void run() throws IOException {
        init();
        System.out.println(checkIce());
//        System.out.println(Arrays.deepToString(visited));
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ice = new int[N][M];
        isIce = new boolean[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                int year = Integer.parseInt(st.nextToken());
                if (year > 0) {
                    deque.offer(new Node(i, j));
                    isIce[i][j] = true;
                    visited[i][j] = 0;
                }
                ice[i][j] = year;
            }
        }

    }

    private int checkIce() {
        int year = 0;
        while (true) {
            if (deque.isEmpty()) {
                return 0; // 빙산이 전부 녹았으면 즉시 종료
            }
            Deque<Node> temp = new LinkedList<>(deque);
            int iter = 0;
            while (!temp.isEmpty()) {
                Node cur = temp.pollFirst();
                if (ice[cur.x][cur.y] == 0) {
                    isIce[cur.x][cur.y] = false;
                    continue;
                }
                ice[cur.x][cur.y] -= 1;
                iter++;
                if (iter == temp.size()) {
                    break;
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (isIce[i][j] && ice[i][j] > 0 && visited[i][j] == 0) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            if (count == 0) {
                return 0; // 빙산이 다 녹았을 경우 종료
            }
            if (count > 1) {
                break; // 빙산이 분리된 경우 종료
            }
            year++;
        }
        return year;
    }

    private void bfs(int x, int y) {
        meltingICe.offer(new Node(x, y));
        visited[x][y] = 1; // 방문 체크 추가

        while (!meltingICe.isEmpty()) {
            Node cur = meltingICe.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (!isIce[nx][ny] || ice[nx][ny] == 0 || visited[nx][ny] == 1) {
                    continue;
                }
                visited[nx][ny] = 1; // 방문 체크
                meltingICe.offer(new Node(nx, ny));
            }
        }
    }


    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


