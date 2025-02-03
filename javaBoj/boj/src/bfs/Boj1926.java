package bfs;

import java.util.*;
import java.io.*;


public class Boj1926 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] draw;
    static boolean[][] visited;
    static int col;
    static int row;


    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        visited = new boolean[col][row];
        draw = new int[col][row];
        for (int i = 0; i < col; i++) {
            StringTokenizer s = new StringTokenizer(bf.readLine());
            for (int j = 0; j < row; j++) {
                draw[i][j] = Integer.parseInt(s.nextToken());
            }
        }
        int landCount = 0;
        int bfsCount = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (!visited[i][j] && draw[i][j] == 1) {
                    landCount = Math.max(bfs(i, j), landCount);
                    bfsCount++;
                }
            }
        }
        System.out.println(bfsCount);
        System.out.println(landCount);

    }

    public static int bfs(int x, int y) {
        Deque<Pair> deque = new LinkedList<>();
        deque.add(new Pair(x, y));
        visited[x][y] = true;
        int count = 0;
        while (!deque.isEmpty()) {
            Pair cur = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= col || ny < 0 || ny >= row) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }

                if (draw[nx][ny] == 0) {
                    continue;
                }
                deque.add(new Pair(nx, ny));
                visited[nx][ny] = true;
            }
            count++;
        }
        return count;
    }

    static class Pair {
        int x;
        int y;

        Pair(int dx, int dy) {
            this.x = dx;
            this.y = dy;
        }
    }
}
