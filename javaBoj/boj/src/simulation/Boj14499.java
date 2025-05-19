package simulation;

import java.io.*;
import java.util.*;

public class Boj14499 {

    static int N;
    static int M;
    static int x;
    static int y;
    static int k;

    static int[][] board;

    static int[] cmd;

    static int[][] dice = {
        {0},
        {0, 0, 0},
        {0},
        {0}
    };

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        Boj14499 process = new Boj14499();
        process.run();
    }

    private void run() throws IOException {
        init();
        makeDice();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        cmd = new int[k];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < k; i++) {
            cmd[i] = Integer.parseInt(st.nextToken());
        }
    }


    private void makeDice() {
        dice[1][1] = board[x][y];

        for (int c : cmd) {
            int nx = x + dx[c - 1];
            int ny = y + dy[c - 1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if (c == 1) {
                rollEast();
            } else if (c == 2) {
                rollWest();
            } else if (c == 3) {
                rollNorth();

            }else {
                rollSouth();
            }
            x = nx;
            y = ny;
            makeBoard();
            System.out.println(dice[3][0]);
        }
    }

    private static void makeBoard() {
        if (board[x][y] == 0) {
            board[x][y] = dice[1][1];
        }else{
            dice[1][1] = board[x][y];
            board[x][y] = 0;
        }
    }

    private void rollEast() {
        int temp = dice[1][1];
        dice[1][1] = dice[1][2];
        dice[1][2] = dice[3][0];
        dice[3][0] = dice[1][0];
        dice[1][0] = temp;
    }

    private void rollWest() {
        int temp = dice[3][0];
        dice[3][0] = dice[1][2];
        dice[1][2] = dice[1][1];
        dice[1][1] = dice[1][0];
        dice[1][0] = temp;
    }

    private void rollNorth() {
        int temp = dice[1][1];
        dice[1][1] = dice[0][0];
        dice[0][0] = dice[3][0];
        dice[3][0] = dice[2][0];
        dice[2][0] = temp;
    }

    private void rollSouth() {
        int temp = dice[0][0];
        dice[0][0] = dice[1][1];
        dice[1][1] = dice[2][0];
        dice[2][0] = dice[3][0];
        dice[3][0] = temp;
    }
}