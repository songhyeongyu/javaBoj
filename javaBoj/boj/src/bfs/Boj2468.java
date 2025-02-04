package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Boj2468 {
    static int N;
    static int[][] land;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxHeight;

    static Deque<Pair> deque = new LinkedList<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    // deque도 새로, visit도 새로 받아야 되고
    public static void main(String[] args) throws IOException{
        Boj2468 process = new Boj2468();
        process.init(bf);
        process.check();

    }

    public void init(BufferedReader bf) throws IOException{
        N = Integer.parseInt(bf.readLine());
        maxHeight = 0;
        land = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(height, maxHeight);
                land[i][j] = height;
            }
        }
    }

    public void check() {
        int maxVal = 0;
        for (int i = 0; i < maxHeight; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && land[j][k] > i) {
                        bfs(j, k, i);
                        cnt++;
                    }
                }
            }
            visited = new boolean[N][N];
            maxVal = Math.max(maxVal, cnt);
        }
        System.out.println(maxVal);
    }

    private static void bfs(int x, int y, int height) {
        deque.offer(new Pair(x,y));
        visited[x][y] = true;
        while (!deque.isEmpty()) {
            Pair cur = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (land[nx][ny] <= height) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                deque.offer(new Pair(nx, ny));
            }
        }
    }




    static class Pair{
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
