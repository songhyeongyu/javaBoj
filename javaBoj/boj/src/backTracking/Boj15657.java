package backTracking;

import java.util.*;
import java.io.*;

public class Boj15657 {
    static int N;
    static int M;
    static int[] num;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Boj15657 process = new Boj15657();
        process.run();
    }

    public void run() throws IOException {
        init();
        func(0, 0);
        System.out.println(sb.toString());
    }

    public void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        arr = new int[N];
        StringTokenizer ss = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(ss.nextToken());
        }
        Arrays.sort(num);
    }

    public void func(int cur, int st) {
        if (cur == M) {
            for (int i = 0; i < M; i++) {
                sb.append(num[arr[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = st; i < N; i++) {
            arr[cur] = i;
            func(cur+1,i);
        }
    }
}
