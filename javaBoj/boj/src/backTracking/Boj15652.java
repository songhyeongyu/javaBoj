package backTracking;

import java.util.*;
import java.io.*;


public class Boj15652 {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        Boj15652 process = new Boj15652();
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

        arr = new int[10];

    }

    public void func(int cur) {
        if (cur == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int st = 1;
        if (cur != 0) {
            st = arr[cur - 1];
        }

        for (int i = st; i < N + 1; i++) {
            arr[cur] = i;
            func(cur+1);
        }
    }

}
