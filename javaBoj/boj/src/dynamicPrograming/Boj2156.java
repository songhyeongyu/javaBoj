package dynamicPrograming;

import java.util.*;
import java.io.*;


public class Boj2156 {
    static int N;
    static int[] wine;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        Boj2156 process = new Boj2156();
        process.run();
    }

    private void run() throws IOException{
        init();
        makeDp();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        wine = new int[N+1];
        dp = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(bf.readLine());
        }
    }

    private void makeDp() {

    }

}
