package dynamicPrograming;

import java.util.*;
import java.io.*;

public class Boj11726 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        Boj11726 process = new Boj11726();
        process.run();
    }

    private void run() throws IOException{
        init();
        dp();
    }

    public void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        dp = new int[Math.max(N+1,3)];
    }

    public void dp() {
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < N + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%10007;
        }
        System.out.println(dp[N]);
    }
}
