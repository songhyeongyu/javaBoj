package bfs;

import java.util.*;
import java.io.*;

public class Boj2667 {
    static int col;
    static int row;
    static int N;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    static Deque<Pair> deque = new LinkedList<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        Boj2667 process = new Boj2667();
        process.init(bf);
        process.check();

    }

    public void init(BufferedReader bf) throws IOException{
        N = Integer.parseInt(bf.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(input);
                int check = Integer.parseInt(String.valueOf(st.nextToken().charAt(j)));
                map[i][j] = check;
            }
        }
    }

    public void check() {
        int bfsCount = 0;
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int value = bfs(i, j);
                    results.add(value);
                    bfsCount++;
                }
            }
        }
        Collections.sort(results);
        System.out.println(bfsCount);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }


    }

    private static int bfs(int x, int y) {
        int count = 1;
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

                if (map[nx][ny] != 1 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                deque.offer(new Pair(nx, ny));
                count++;
            }
        }

        return count;

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
