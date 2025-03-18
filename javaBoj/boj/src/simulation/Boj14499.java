package simulation;

import java.io.*;
import java.util.*;

public class Boj14499 {

    //결국 1,1에 오는 놈이 무엇인지
    static int[][] dice = {{-1, 0, -1}, {0, 0, 0}, {-1, 0, -1}, {-1, 0, -1}};
    static int[][] board;
    static int N;
    static int M;
    static int x;
    static int y;
    static int K;
    static int[] cmd;

    //1. 남쪽으로 굴렸을 떄
    public static void main(String[] args) throws IOException{
        Boj14499 process = new Boj14499();
        process.run();
    }

    private void run() throws IOException {
        init();
        makeDice();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        cmd = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < K; i++) {
            cmd[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void makeDice() {

        for (int i = 0; i < K; i++) {
            int num = cmd[i];

            if (num == 1) {
                rollEast();
            }
            else if (num == 2) {
                rollWest();
            } else if (num == 3) {
                rollNorth();
            } else if (num == 4) {
                rollSouth();
            }



//            System.out.println(Arrays.deepToString(dice));

        }

    }

    private void rollNorth() {
        if (!validRange(x - 1, y)) return;
        x--;
        //        static int[][] dice = {{-1, 0, -1}, {0, 0, 0}, {-1, 0, -1}, {-1, 0, -1}};

        int temp = dice[0][1];
        int temp2 = dice[1][1];
        int temp3 = dice[2][1];
        int temp4 = dice[3][1];

        dice[0][1] = temp4;
        dice[1][1] = temp;
        dice[2][1] = temp2;
        dice[3][1] = temp3;

        process();
        System.out.println(dice[3][1]);
    }

    private void rollSouth() {
        if (!validRange(x + 1, y)) return;
        x++;


        int temp = dice[0][1];
        int temp2 = dice[1][1];
        int temp3 = dice[2][1];
        int temp4 = dice[3][1];

        dice[0][1] = temp2;
        dice[1][1] = temp3;
        dice[2][1] = temp4;
        dice[3][1] = temp;
        process();
        System.out.println(dice[3][1]);

    }


    private void rollEast() {
        if (!validRange(x, y + 1)) return;
        y++;
//        static int[][] dice = {{-1, 0, -1}, {0, 0, 0}, {-1, 0, -1}, {-1, 0, -1}};

        int temp = dice[1][0];
        int temp2 = dice[1][1];
        int temp3 = dice[1][2];
        int temp4 = dice[3][1];


        dice[1][1] = temp3;
        dice[1][0] = temp2;
        dice[1][2] = temp4;
        dice[3][1] = temp;

        process();
        System.out.println(dice[3][1]);


    }

    private void rollWest() {
        if (!validRange(x, y - 1)) return;
        y--;
        //        static int[][] dice = {{-1, 0, -1}, {0, 0, 0}, {-1, 0, -1}, {-1, 0, -1}};

        int temp = dice[1][0];
        int temp2 = dice[1][1];
        int temp3 = dice[1][2];
        int temp4 = dice[3][1];


        dice[1][0] = temp4;
        dice[1][1] = temp;
        dice[1][2] = temp2;
        dice[3][1] = temp3;

        process();
        System.out.println(dice[3][1]);
    }

    private boolean validRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    private void process() {
        if(board[x][y] != 0) {
            dice[1][1] = board[x][y];
            board[x][y] = 0;
        }
        else {
            board[x][y] = dice[1][1];
        }
    }


}



