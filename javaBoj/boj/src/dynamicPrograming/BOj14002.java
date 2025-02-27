package dynamicPrograming;

import java.util.*;
import java.io.*;


public class BOj14002 {
    static int N;
    static int[] arr;
    static int[] dp;
    static int[] trace;


    public static void main(String[] args) throws IOException{
        BOj14002 process = new BOj14002();
        process.run();
    }

    private void run() throws IOException{
        init();
        findDp();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        dp = new int[N];
        trace = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void findDp() {
        StringBuilder sb = new StringBuilder();
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }

        int ans = Arrays.stream(dp).max().orElse(0);
        System.out.println(ans + 1);

        for (int i = N - 1; i > -1; i--) {
            if (dp[i] == ans) {
                sb.insert(0,arr[i] + " ");
                ans--;
            }
        }
        System.out.println(sb.toString());

    }
}
