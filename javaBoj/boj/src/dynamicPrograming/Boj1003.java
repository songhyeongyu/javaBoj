package dynamicPrograming;

import java.io.*;

public class Boj1003 {
    static int T;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Boj1003 process = new Boj1003();
        T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            process.run();
        }
    }

    private void run() throws IOException{
        init();
    }

    private void init() throws IOException{
        int N = Integer.parseInt(bf.readLine());
        fibonacci(N);
    }

    private void fibonacci(int n) {
        if (n == 0) {
            System.out.println("1 0");
            return;
        } else if (n == 1) {
            System.out.println("0 1");
            return;
        }
        int[] dp = new int[Math.max(n + 1, 3)];


        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        System.out.println(dp[n-1] + " " + dp[n]);
    }
}
