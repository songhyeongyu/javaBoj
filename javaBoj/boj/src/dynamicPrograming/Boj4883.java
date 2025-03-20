package dynamicPrograming;

import java.io.*;
import java.util.*;

public class Boj4883 {
    static int N;
    static int T = 1;
    static int[][] board;
    static int[][] d;
//    static int[][] d1 = {{0, 1}, {1, 1}, {0, 1}};
    static  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        Boj4883 process = new Boj4883();
        while (true) {
            N = Integer.parseInt(bf.readLine());

            if (N == 0) {
                break;
            }
            process.run();
            T++;
        }
    }

    private void run() throws IOException {
        init();
        dp();
    }

    private void init() throws IOException {

        board = new int[N][3];
        d = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    private void dp() {
        d[0][0] = Integer.MAX_VALUE;
        d[0][1] = board[0][1];
        d[0][2] = d[0][1] + board[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if(j==0) {
                    if (i == 1) {
                        d[i][j] = d[i - 1][j] + board[i][j];
                    }else{
                        d[i][j] = Math.min(d[i - 1][j], d[i - 1][j] + board[i - 1][1]) + board[i][j];
                    }
                } else if (j == 1) {
                    if (i == 1) {
                        d[i][j] = Math.min(d[i - 1][1], d[i - 1][2] + d[i - 1][1])+ board[i][j];
                    }
                    else{
                        d[i][j] = Math.min(Math.min(d[i - 1][1] + board[i][0], d[i - 1][1]), d[i - 1][1] + d[i - 1][2]) + board[i][j];
                    }
                }else{
                    if (i == 1) {
                        d[i][j] = Math.min(Math.min(d[i - 1][2], d[i - 1][1]), d[i-1][2] + d[i][1]) + board[i][j];
                    }
                    else{
                        d[i][j] = Math.min(Math.min(d[i - 1][1], d[i - 1][2]), d[i - 1][2] + board[i][1]) + board[i][j];
                    }
                }
            }
        }

//        System.out.println(Arrays.deepToString(d));
        System.out.println(T + ". " +d[N-1][1]);
        /**
         * 1. d[n][0] = d[n-1][0] or d[n-1][1] or d[n-1][1] + arr[n][1]
         * 2. d[n][1] = d[n-1][0] or d[n-1][1] or d[n-1][2] or d[n-1][1] + board[n][0] or d[n-1][1] + board[n][2]
         * 3. d[i][2] = d[i-1][1] or d[i-1][2] or d[i-1][2] + board[i][1]
         *
         */
    }
}
