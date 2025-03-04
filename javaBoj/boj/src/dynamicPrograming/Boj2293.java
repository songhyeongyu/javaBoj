package dynamicPrograming;

import java.io.*;
import java.util.*;


public class Boj2293 {
    static int N;
    static int K;

    static int[] coin;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        Boj2293 process = new Boj2293();
        process.run();

    }

    private void run() throws IOException{
        init();
        findDp();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coin = new int[N + 1];
        dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            coin[i] = Integer.parseInt(bf.readLine());
        }
    }

    private void findDp() {
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = coin[i]; j <= K; j++) {
                dp[j] = dp[j] + dp[j - coin[i]];
            }
        }

        System.out.println(Arrays.toString(dp));
    }
}
