package dynamicPrograming;

import java.io.*;
import java.util.*;

public class Boj11053 {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        Boj11053 process = new Boj11053();
        process.run();
    }

    private void run() throws IOException{
        init();
        dp();
        printMaxValue();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void dp() {
        int count = 0;
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + (count + 1));
                }
            }
        }
    }

    private void printMaxValue() {
        int maxValue = Arrays.stream(dp).max().orElse(Integer.MIN_VALUE);
        System.out.println(maxValue + 1);
    }
}
