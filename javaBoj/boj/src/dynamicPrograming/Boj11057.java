package dynamicPrograming;


import java.io.*;
import java.util.Arrays;

public class Boj11057 {

    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        Boj11057 process = new Boj11057();
        process.run();
    }

    private void run() throws IOException {
        init();
        findDp();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        dp = new int[N + 1][10];

    }

    private void findDp() {
        Arrays.fill(dp[1], 1);
        System.out.println(Arrays.deepToString(dp));
        for (int i = 2; i <= N; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <10; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1])%10_007;
            }
        }

        System.out.println(Arrays.deepToString(dp));
        long total = Arrays.stream(dp[N]).sum();
        System.out.println(total);
    }
}
