package bfs;

import java.util.*;
import java.io.*;


public class Boj2146 {
    static int N;
    static int[][] island;
    static boolean[][] visited;
    static int[][] dist;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        Boj2146 process = new Boj2146();
        process.run();
    }

    private void run() throws IOException {
        init();
        findLand();
        System.out.println(Arrays.deepToString(island));
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        island = new int[N][N];
        visited = new boolean[N][N];
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                island[i][j] = input;
            }
        }
    }

    private void findLand() {
        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || island[i][j] == 0) {
                    continue;
                }
                Queue<Node> q = new LinkedList<>();
                q.offer(new Node(i, j));
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    Node cur = q.poll();
                    island[cur.x][cur.y] = idx;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || island[nx][ny] == 0) {
                            continue;
                        }
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        island[nx][ny] = idx;
                    }
                }
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
