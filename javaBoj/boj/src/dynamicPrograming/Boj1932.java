package dynamicPrograming;

import java.io.*;
import java.util.*;

public class Boj1932 {
    static int N;
    static int[][] triangle;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        Boj1932 process = new Boj1932();
        process.run();
    }

    private void run() throws IOException {
        init();
        System.out.println(dp());
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        triangle = new int[N][];
        dp = new int[N][];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            triangle[i] = new int[i + 1];
            dp[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public int dp() {
        if (N == 1) {
            return triangle[0][0];
        }

        if (N == 2) {
            return triangle[0][0] +Math.max(triangle[1][0], triangle[1][1]);
        }


        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[1][0] + triangle[0][0];
        dp[1][1] = triangle[1][1] + triangle[0][0];

        for (int i = 2; i < N; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == dp[i].length - 1) {
                    dp[i][j] = dp[i - 1][j-1] + triangle[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }

        }

        return Arrays.stream(dp[dp.length - 1])
                .max()
                .orElse(Integer.MAX_VALUE);
    }
}
