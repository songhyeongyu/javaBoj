package backTracking;

import java.util.*;
import java.io.*;

/*조합*/
public class Boj15655 {

    static int N;
    static int M;
    static int[] arr;
    static int[] ans;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        Boj15655 process = new Boj15655();

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

        StringTokenizer stArr = new StringTokenizer(bf.readLine());

        arr = new int[N+1];
        ans = new int[10];
        isUsed = new boolean[10];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
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

        for (int i = 1; i < N+1; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                ans[cur] = arr[i];
                func(cur+1);
                isUsed[i] = false;
            }

        }
    }
}

