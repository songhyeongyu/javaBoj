package dynamicPrograming;

import java.io.*;
import java.util.*;

public class Boj11659 {
    static int[] dp;
    static int[] arr;
    static int N;
    static int M;
    static ArrayList<Pair> pairs = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Boj11659 process = new Boj11659();
        process.run();
    }

    public void run() throws IOException{
        init();
        dp();
        printResult();
    }

    public void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        arr = new int[N + 1];
        dp = new int[Math.max(N+1,2)];

        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pairs.add(new Pair(x, y));
        }

    }

    public void dp() {
        dp[1] = arr[1];
        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }
    }

    public void printResult() {
        for (Pair pair : pairs) {
            System.out.println(dp[pair.y]-dp[pair.x -1]);
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
