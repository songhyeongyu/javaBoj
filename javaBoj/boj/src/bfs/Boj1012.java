package bfs;

import java.util.*;
import java.io.*;


public class Boj1012 {

    static int col;
    static int row;
    static int worm;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] land;
    static Deque<Pair> deque = new LinkedList<>();


    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Boj1012 process = new Boj1012();
        for (int i = 0; i < N; i++) {
            process.init(bf);
            int ans = process.check();
            System.out.println(ans);
        }

    }

    public void init(BufferedReader bf) throws IOException{
        String line = bf.readLine();
        StringTokenizer st = new StringTokenizer(line);

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        worm = Integer.parseInt(st.nextToken());


        land = new int[col][row];
        visited = new boolean[col][row];

        for (int i = 0; i < worm; i++) {
            line = bf.readLine();

            StringTokenizer wm = new StringTokenizer(line);

            int r = Integer.parseInt(wm.nextToken()); // X 좌표 (가로)
            int c = Integer.parseInt(wm.nextToken()); // Y 좌표 (세로)

            land[c][r] = 1;
        }

    }

    public void bfs(int c, int r) {
        deque.offer(new Pair(c, r));
        visited[c][r] = true;

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

                if (land[nx][ny] == 0) {
                    continue;
                }
                visited[nx][ny] = true;
                deque.offer(new Pair(nx, ny));
            }
        }
    }

    public int check() {
        int count = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (!visited[i][j] && land[i][j] != 0) {
                    bfs(i,j);
                    count++;
                }
            }
        }
        return count;
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
