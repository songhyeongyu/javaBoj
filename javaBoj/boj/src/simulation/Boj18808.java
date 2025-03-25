package simulation;

import java.io.*;
import java.util.*;

public class Boj18808 {

    /**
     * 스티커를 회전 x
     * 스티커 붙일 수 있는 위치 찾음 -> 여러곳이 있으면 위쪽 왼쪽부터 -> 위쪽 오른쪽까지
     */

    static int r;
    static int c;
    static int s;
    static int[][] board;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    List<int[][]> stickerSet = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Boj18808 process = new Boj18808();
        process.run();
    }

    private void run() throws IOException{
        init();

        System.out.println(Arrays.deepToString(board));
    }

    private void init() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        board = new int[r][c];

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[r][c];
            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < c; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            stickerSet.add(sticker);
            }



    }


    private int[][] turnRight(int x, int y,int[][] sticker) {
        int temp = x;
        x = y;
        y = temp;
        int[][] tempArr = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tempArr[i][(y - 1) - j] = sticker[j][i];
            }
        }

        return tempArr;
    }





}
