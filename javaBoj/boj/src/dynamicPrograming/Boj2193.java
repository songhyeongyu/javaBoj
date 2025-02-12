package dynamicPrograming;

import java.io.*;

public class Boj2193 {
    static int N;
    static long[] dp;


    public static void main(String[] args) throws IOException {
        Boj2193 process = new Boj2193();
        process.run();
    }

    private void run() throws IOException{
        init();
        System.out.println(func());
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        dp = new long[Math.max(N + 1, 2)];
    }

    private long func() {
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 1;
        }
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < N+1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }


}
