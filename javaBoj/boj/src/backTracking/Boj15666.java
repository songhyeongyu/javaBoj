package backTracking;

import java.util.*;
import java.io.*;

public class Boj15666 {
    static int N;
    static int M;
    static int[] arr;
    static int[] temp;
    static boolean[] isused;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        Boj15666 process = new Boj15666();
        process.run();
    }

    private void run() throws IOException{
        init();
        func(0,0);
        System.out.println(sb.toString());
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        temp = new int[N];
        isused = new boolean[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

    }

    private void func(int cur, int st) {
        if (cur == M) {
            for (int i = 0; i < M; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int tmp = 0;
        for (int i = st; i < N; i++) {
            if(tmp != arr[i]) {
                temp[cur] = arr[i];
                tmp = arr[i];
                func(cur + 1,i);
            }
        }
    }
}
