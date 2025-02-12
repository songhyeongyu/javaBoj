package dynamicPrograming;

import java.io.*;
import java.util.*;

public class Boj1149 {
    static int N;
    static int[] r;
    static int[] g;
    static int[] b;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        Boj1149 process = new Boj1149();
        process.run();
    }

    public void run() throws IOException{
        init();
        dp();
        searchMinValue();
    }

    public void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        r = new int[N];
        g = new int[N];
        b = new int[N];
        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
    }

    public void dp() {
        dp[0][0] = r[0];
        dp[0][1] = g[0];
        dp[0][2] = b[0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r[i];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g[i];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b[i];
        }
    }

    public void searchMinValue() {
        int minValue = Arrays.stream(dp[dp.length - 1])
                .min()
                .orElse(Integer.MAX_VALUE);
        System.out.println(minValue);
    }



}

