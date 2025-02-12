package dynamicPrograming;

import java.io.*;


public class Boj9055 {
    static int T;
    static int N;
    static int[] dp;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        Boj9055 process = new Boj9055();
        T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            process.run();
        }

    }

    public void run() throws IOException{
        init();
        int ans = dp();
        System.out.println(ans);
    }

    public void init() throws IOException{
        N = Integer.parseInt(bf.readLine());
        dp = new int[Math.max(N + 1, 4)];
    }

    public int dp() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < N + 1; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[N];
    }
}
