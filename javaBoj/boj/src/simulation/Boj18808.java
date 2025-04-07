package simulation;

import java.io.*;
import java.util.*;

public class Boj18808 {
    static int N;
    static int M;
    static int K;
    static int[][] board;

    public static void main(String[] args) throws IOException{
        Boj18808 process = new Boj18808();
        process.run();
    }

    private void run() throws IOException{
        init();
        System.out.println(countZero());
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        while (K> 0) {
            K--;
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[r][c];
            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < c; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int rotate = 0; rotate < 4; rotate++) {
                int x = sticker.length;
                int y = sticker[0].length;
                boolean flag = false;
                for (int i = 0; i <= N - x; i++) {
                    if (flag) {
                        break;
                    }
                    for (int j = 0; j <= M - y; j++) {
                        if (paste(i, j, sticker)) {
                            flag = true;
                            break;
                        }
                    }
                }

                if (flag) {
                    break;
                }
                sticker = turn(sticker);
            }


        }

    }

    private boolean paste(int r, int c, int[][] sticker) {
        int x = sticker.length;
        int y = sticker[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[r + i][c + j] == 1 && sticker[i][j] == 1) {
                    return false;
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (sticker[i][j] == 1) {
                    board[i + r][j + c] = 1;
                }
            }
        }
        return true;
    }


    private int[][] turn(int[][] arr) {
        int r = arr[0].length;
        int c = arr.length;

        int[][] temp = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = arr[(c - 1) - j][i];
            }
        }
        return temp;
    }

    private int countZero() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }


}
