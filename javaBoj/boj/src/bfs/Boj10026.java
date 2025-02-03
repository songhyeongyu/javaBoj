package bfs;

import java.util.*;
import java.io.*;

public class Boj10026 {
    static int N;
    static char[][] rgb;
    static char[][] rrb;
    static boolean[][] visitedRgb;
    static boolean[][] visitedRrb;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Boj10026 process = new Boj10026();
        process.init(bf);
        process.countArea();
    }

    public void init(BufferedReader bf) throws IOException {
        String line = bf.readLine();
        N = Integer.parseInt(line);

        rgb = new char[N][N];
        rrb = new char[N][N];
        visitedRgb = new boolean[N][N];
        visitedRrb = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            line = bf.readLine();
            for (int j = 0; j < N; j++) {
                char color = line.charAt(j);
                rgb[i][j] = color;
                changeColor(color, i, j);
            }
        }
    }
    private static void changeColor(char color, int i, int j) {
        if (color == 'G') {
            rrb[i][j] = 'R';
        } else {
            rrb[i][j] = color;
        }
    }
    public void countArea() {
        int rgbCount = 0;
        int rrbCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedRgb[i][j]) {
                    bfs(rgb,visitedRgb,i,j);
                    rgbCount++;
                }

                if (!visitedRrb[i][j]) {
                    bfs(rrb,visitedRrb,i,j);
                    rrbCount++;
                }

            }
        }

        System.out.print(rgbCount +" "+ rrbCount);

    }


    private static void bfs(char[][] color, boolean[][] visited, int x, int y) {
        Deque<Pair> deque = new LinkedList<>();
        deque.offer(new Pair(x, y));
        visited[x][y] = true;

        while (!deque.isEmpty()) {
            Pair cur = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (color[cur.x][cur.y] != color[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                deque.offer(new Pair(nx, ny));
            }
        }

    }


    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
