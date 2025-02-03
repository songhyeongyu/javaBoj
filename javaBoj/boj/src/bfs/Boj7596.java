package bfs;

import java.util.*;
import java.io.*;

public class Boj7596 {
    static int col;
    static int row;
    static int height;
    static int[][][] tomato;
    static int[][][] day;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Deque<Pair> deque = new LinkedList<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Boj7596 process = new Boj7596();
        process.init();

    }

    public void init() throws IOException{
        String line = bf.readLine();
        StringTokenizer st = new StringTokenizer(line);

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        tomato = new int[col][row][height];
        day = new int[col][row][height];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                Arrays.fill(day[i][j],-1);
            }
        }

        for (int k = 0; k < height; k++) {
            for (int i = 0; i < col; i++) {
                line = bf.readLine();
                for (int j = 0; j < row; j++) {
                    StringTokenizer s = new StringTokenizer(line);
                    int isTomato = Integer.parseInt(s.nextToken());
                    if (isTomato == 1) {
                        day[i][j][k] = 0;
                        deque.offer(new Pair(i, j, k));
                    }
                    tomato[i][j][k] = isTomato;
                }
            }
        }
        System.out.println(Arrays.deepToString(tomato));
        System.out.println(Arrays.deepToString(day));

    }






    static class Pair{
        int x;
        int y;
        int z;

        Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
