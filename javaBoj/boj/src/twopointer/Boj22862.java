package twopointer;

import java.io.*;
import java.util.*;

public class Boj22862{

    static int N;
    static int K;

    static int[] arr;
    static Set<Integer> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        Boj22862 process = new Boj22862();
        process.run();
    }

    private void run() throws IOException {
        init();
        int ans = twoPointer();
        System.out.println(ans);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }


    private int twoPointer() {
        int end = 0;
        int ans = Integer.MIN_VALUE;
        int cnt = 0;
        for (int st = 0; st < N; st++) {
            while (end < N && K >= 0) {
                if (arr[end] % 2 != 0) {
                    K -= 1;
                    cnt++;
                }
                end++;
            }

            ans = Math.max(ans,end - st - cnt);

            if (arr[st] % 2 != 0) {
                K += 1;
                cnt--;
            }
        }
        return ans;
    }
}

