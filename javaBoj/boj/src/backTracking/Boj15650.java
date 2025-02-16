package backTracking;

import java.util.*;
import java.io.*;


public class Boj15650 {
    private static int N;
    private static int M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] isUsed;


    public static void main(String[] args) throws IOException{

        Boj15650 process = new Boj15650();
        process.run();
    }

    private void run() throws IOException{
        init();
        func(0);
        System.out.println(sb.toString());
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        isUsed = new boolean[N + 1];
        Arrays.fill(arr, 0);
    }

    private void func(int cur) {
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
        for (int i = st; i < N+1; i++) {
            if (!isUsed[i]) {
                arr[cur] = i;
                isUsed[i] = true;
                func(cur + 1);
                isUsed[i] = false;


            }

        }
    }

}
