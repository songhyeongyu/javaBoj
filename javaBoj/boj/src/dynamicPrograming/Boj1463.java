package dynamicPrograming;

import java.util.*;
import java.io.*;


public class Boj1463 {
    static int N;
    static int[] dp;


    public static void main(String[] args) throws IOException{
        Boj1463 process = new Boj1463();
        process.run();
    }

    public void run() throws IOException{
        init();
        dp();
        System.out.println(dp[N]);
    }

    public void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        dp = new int[N+1];
    }

    public void dp() {
        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i],dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
    }
}
