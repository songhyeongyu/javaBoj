package dynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2240 {
    static int T;
    static int W;
    static int[] fruit;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        Boj2240 process = new Boj2240();
        process.run();
    }

    private void run() throws IOException{
        init();
        dp();
    }
    
    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        fruit = new int[T+1];
        dp = new int[T + 1][W+1];

        for (int i = 1; i <= T; i++) {
            fruit[i] = Integer.parseInt(bf.readLine());
        }

    }

    private void dp() {
    }
    
    
    

}










