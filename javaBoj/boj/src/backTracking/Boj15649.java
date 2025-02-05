package backTracking;

import java.io.*;
import java.util.*;

public class Boj15649 {

    static int n, m;
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        Boj15649 process = new Boj15649();
        process.run();

    }


    public void run() throws IOException{
        init();
        back(0);
        System.out.println(sb);
    }

    public void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }

    public void back(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                back(k + 1);
                isUsed[i] = false;
            }
        }
    }
}
