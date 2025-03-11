package recursion;

import java.io.*;
import java.util.*;

public class Boj1780 {
    static int N;
    static int[][] board;
    static int zero;
    static int minus;
    static int plus;



    public static void main(String[] args) throws IOException{
        Boj1780 process = new Boj1780();
        process.run();
    }

    private void run() throws IOException {
        init();
        func(0,0,N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private void func(int x, int y, int n) {
        if (n == 0) {
            return;
        }

        int half = n / 3;
        if (isEqual(x, y, n)) {
            if (board[x][y] == -1) {
                minus += 1;
            }
            if (board[x][y] == 1) {
                plus += 1;
            }
            if (board[x][y] == 0) {
                zero += 1;
            }
        }

        else{
            func(x, y, n/3);
            func(x+half, y, n/3);
            func(x, y+half, n/3);
            func(x+half, y+half, n/3);
        }



    }



    private boolean isEqual(int x, int y, int half) {
        int first = board[x][y];

        for (int i = x; i < x + half; i++) {
            for (int j = y; j < y + half; j++) {
                if (first != board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}


