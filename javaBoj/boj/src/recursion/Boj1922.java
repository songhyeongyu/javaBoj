package recursion;

import java.util.*;
import java.io.*;


public class Boj1922 {
    static int N;
    static char[][] board;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException{
        Boj1922 process = new Boj1922();
        process.run();
    }

    private void run() throws IOException {
        init();
        recursion(0, 0, N);
        System.out.println(sb.toString());
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
            }
        }

    }

    private void recursion(int x, int y, int n) {
        if (isSame(x, y, n)) {
            char fist = board[x][y];
//            sb.append("(");
            sb.append(fist);
            return;
        }
        sb.append("(");
        int half = n / 2;
        recursion(x, y, n / 2);
        recursion(x, y + half, n / 2);
        recursion(x + half, y, n / 2);
        recursion(x + half, y + half, n / 2);
        sb.append(")");
    }

    private boolean isSame(int x, int y, int n) {
        int first = board[x][y];

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (first != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
