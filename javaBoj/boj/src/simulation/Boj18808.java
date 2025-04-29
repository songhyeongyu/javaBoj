package simulation;

import java.util.*;
import java.io.*;

public class Boj18808 {
    static int N;
    static int M;
    static int K;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board;

    public static void main(String[] args) throws IOException {
        Boj18808 process = new Boj18808();
        process.run();
    }

    private void run() throws IOException {
        init();
        make();
        int ans = countSticker();
        System.out.println(ans);
    }

    private void init() throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
    }

    private void make() throws IOException {
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] s = new int[n][m];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < m; k++) {
                    s[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 4; j++) {
                int x = s.length;
                int y = s[0].length;
                boolean flag = false;
                for (int k = 0; k <= N - x; k++) {
                    if (flag) {
                        break;
                    }
                    for (int l = 0; l <= M - y; l++) {
                        flag = isPaste(s, l, k, x, y);
                        if (flag) {
                            paste(s, k, l, x, y);
                            break;
                        }
                    }
                }

                if (flag) {
                    break;
                }
                else{
                    s = turnRight(s);
                }
            }
        }
    }

    private void paste(int[][] s, int k, int l, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(s[i][j] == 1)
                    board[i + k][j + l] = 1;
            }
        }
    }


    private boolean isPaste(int[][] s, int l, int k, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (s[i][j] == 1 && board[i+k][j+l] == 1) {
                    return false;
                }
            }
        }
        return true;
    }


    private int[][] turnRight(int[][] board) {
        int[][] temp = new int[board[0].length][board.length];
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                temp[i][j] = board[(board.length - 1) - j][i];
            }
        }


        return temp;
    }

    private int countSticker() {
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
