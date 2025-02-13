package dynamicPrograming;

import java.util.*;
import java.io.*;


public class Boj1912 {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        Boj1912 process = new Boj1912();
        process.run();
    }

    public void run() throws IOException{
        init();
        dp();
        printMax();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[Math.max(N + 1,3)];
        dp = new int[Math.max(N + 1,2)];
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


    }

    private void dp() {
        dp[0] = Integer.MIN_VALUE;
        dp[1] = arr[1];

        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + arr[i];
        }
        System.out.println(Arrays.toString(dp));
    }

    private void printMax() {
        int maxValue = Arrays.stream(dp).max().orElse(Integer.MAX_VALUE);

        System.out.println(maxValue);
    }
}
