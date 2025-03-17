package dynamicPrograming;

import java.util.*;
import java.io.*;

public class Boj14501 {

    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        Boj14501 process = new Boj14501();
        process.run();
    }

    private void run() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        T = new int[N + 1];
        P = new int[N + 1];
        dp = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int time = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            T[i] = time;
            P[i] = price;
        }

        func();
    }

    private void func() {
        dp[0] = 0;
        dp[1] = 10;
        for (int i = 1; i <= N; i++) {
            int time = T[i] + i;
            for (int j = T[i] + 1; j <= N; j++) {
                if (time < N) {
                    dp[i] = Math.max(dp[j], dp[i] + P[j]);
                    time += T[j] + 1;
                }
            }
        }

        System.out.println(Arrays.toString(dp));
    }

}




