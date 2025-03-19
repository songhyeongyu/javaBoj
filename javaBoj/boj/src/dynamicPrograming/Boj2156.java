package dynamicPrograming;

import java.io.*;
import java.util.*;

public class Boj2156 {
    static int N;
    static int[] wine;
    static int[][] d;

    public static void main(String[] args) throws IOException{
        Boj2156 process = new Boj2156();
        process.run();
    }

    private void run() throws IOException {
        init();
        dp();
        findMaxValue();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(bf.readLine());
        wine = new int[Math.max(N + 1,3)];
        d = new int[Math.max(N + 1,3)][3];
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(bf.readLine());
            wine[i] = num;
        }


    }

    private void dp() {
        d[1][1] = wine[1];
        d[2][1] = wine[2];
        d[1][2] = 0;
        d[2][2] = wine[1] + wine[2];


        for (int i = 3; i <= N; i++) {
            d[i][1] = Math.max(Math.max(d[i - 2][2],d[i-2][1]), d[i - 3][2]) + wine[i];
            d[i][2] = d[i - 1][1] + wine[i];
        }
    }


    private void findMaxValue() {
        int maxVale = Integer.MIN_VALUE;

        for (int[] m : d) {
            maxVale = Math.max(maxVale,Arrays.stream(m).max().orElse(0));
        }

        System.out.println(maxVale);
    }
}



