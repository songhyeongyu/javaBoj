package simulation;

import java.io.*;
import java.util.*;

public class Boj18808 {

    /**
     * 스티커를 회전 x
     * 스티커 붙일 수 있는 위치 찾음 -> 여러곳이 있으면 위쪽 왼쪽부터 -> 위쪽 오른쪽까지
     * 위치에 붙이고 -> 위치가 없으면 -> 90도로 2번 회전(시계방향)
     */

    static int r;
    static int c;
    static int s;
    static int[][][] sticker;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        Boj18808 process = new Boj18808();
        process.run();
    }

    private void run() throws IOException{
        init();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        sticker = new int[s][r][c];
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sticker[i] = new int[n][m];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < m; k++) {
                    sticker[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

    }

    /*
1 3 3
2 3
1 0 0
1 1 1
1 1
1
3 1
1
1
1
     */

    /**
     * 남은 공간 산을 해야 되나? 어디가 남았는지 ?
     */
    private void paste() {
        for (int i = 0; i < s; i++) {
            if (isPaste(sticker[i])) {
                changeBoard(sticker[i]);
            }
            else{

            }
        }
    }

    private void moveSticker(int[][] arr) {

    }

    private void changeBoard(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                board[i][j] = arr[i][j];
            }
        }

    }

    private boolean isPaste(int[][] arr) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] turnRight(int i, int n, int m) {
        int[][] rotated = new int[m][n];

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                rotated[j][k] = sticker[i][n - 1 - k][j];
            }
        }

        return rotated;
    }

    private int[][] turn(int i, int n, int m) {
        int[][] rotate = new int[n][m];

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                rotate[j][k] = sticker[i][(n-1) - j][k];
            }
        }

        return rotate;
    }

}
