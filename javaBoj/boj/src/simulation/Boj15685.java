package simulation;

import java.util.*;
import java.io.*;

public class Boj15685 {

    static int N;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] board;

    public static void main(String[] args) throws IOException{
        Boj15685 process = new Boj15685();
        process.run();
    }

    private void run() throws IOException {
        init();
        System.out.println(countSquare());
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        board = new boolean[102][102];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            makeDragon(x, y, d, g);
        }
    }

    private void makeDragon(int x, int y, int d, int g) {
        List<Integer> dragons = new ArrayList<>();

        board[x][y] = true;
        dragons.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = dragons.size() - 1; j > -1; j--) {
                int cur = dragons.get(j);
                int nd = (cur + 1) % 4;
                dragons.add(nd);
            }
        }

        for (Integer dragon : dragons) {
            x += dx[dragon];
            y += dy[dragon];
            board[x][y] = true;
        }
    }

    private int countSquare() {
        int count = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (board[i][j] && board[i + 1][j] && board[i + 1][j + 1] && board[i][j + 1]) {
                    count++;
                }
            }
        }
        return count;
    }

}
