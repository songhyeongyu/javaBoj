package backTracking;

import java.util.*;
import java.io.*;

public class Boj6603 {
    static int N;
    static boolean[] used;
    static int[] arr;
    static int[] num;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        Boj6603 process = new Boj6603();
        while (true) {
            if (hello()) break;
            process.run();
            sb = new StringBuilder();
        }
    }

    private static boolean hello() throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        if (N == 0) {
            return true;
        }
        used = new boolean[N + 1];
        arr = new int[N + 1];
        num = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        return false;
    }

    private void run() throws IOException {
        func(0,0);
        System.out.println(sb.toString());
    }

    private void func(int cur, int st) {
        if (cur == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }


        int tmp = 0;


        for (int i = st; i <= N; i++) {
            if (tmp != num[i] && !used[i]) {
                used[i] = true;
                arr[cur] = num[i];
                tmp = arr[cur];
                func(cur + 1,i);
                used[i] = false;
            }
        }
    }

}
