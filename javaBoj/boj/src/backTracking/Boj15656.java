package backTracking;

import java.util.*;
import java.io.*;


public class Boj15656 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] isUsed;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException{
        Boj15656 process = new Boj15656();
        process.run();
    }

    public void run() throws IOException{
        init();
        func(0);
        System.out.println(sb.toString());
    }


    public void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringTokenizer ss = new StringTokenizer(bf.readLine());
        arr = new int[N + 1];
        isUsed = new boolean[10];
        ans = new int[10];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ss.nextToken());
        }
        Arrays.sort(arr);
    }

    public void func(int cur) {
        if (cur == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < N + 1; i++) {
                ans[cur] = arr[i];
                func(cur+1);
        }
    }
}
