package simulation;

import java.io.*;
import java.util.*;

public class Boj18808 {
    static int N;
    static int M;
    static int K;

    static int[][] board;

    public static void main(String[] args) throws IOException {
        Boj18808 process = new Boj18808();
        process.run();
    }

    private void run() throws IOException {
        init();
        System.out.println(Arrays.deepToString(board));
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        board = new int[N][M];

    }


        private int[][] turn ( int[][] sticker){
            int[][] temp = new int[sticker[0].length][sticker.length];

            for (int i = 0; i < sticker[0].length; i++) {
                for (int j = 0; j < sticker.length; j++) {
                    temp[i][j] = sticker[(sticker.length - 1) - j][i];
                }
            }

            return temp;
        }


}
