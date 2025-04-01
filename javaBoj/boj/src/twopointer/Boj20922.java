package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj20922 {
    static int N;
    static int K;
    static int[] arr;
    static int[] numCnt;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        Boj20922 process = new Boj20922();
        process.run();
    }

    private void run() throws IOException {
        init();
        two();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        numCnt = new int[100_001];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }

    private void two() {
        int end = 0;
        int len = 0;
        for (int st = 0; st < N; st++) {
            while (end < N && numCnt[arr[end]] < K) {
                numCnt[arr[end]]++;
                end++;
            }
            len = end - st;

            result = Math.max(len, result);
            numCnt[arr[st]]--;
        }

        System.out.println(result);
    }
}
