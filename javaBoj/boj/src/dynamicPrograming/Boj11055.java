package dynamicPrograming;

import java.util.*;
import java.io.*;

public class Boj11055 {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        Boj11055 process = new Boj11055();
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
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i <N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }
    }

    private void dp() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

    }

    private void printMaxValue() {
        int maxValue = Arrays.stream(dp).max().orElse(Integer.MIN_VALUE);
        System.out.println(maxValue);
    }
}
