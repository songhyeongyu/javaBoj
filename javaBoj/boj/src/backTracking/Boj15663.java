package backTracking;

import java.util.*;
import java.io.*;


public class Boj15663 {
    static int N;
    static int M;
    static int[] num;
    static int[] arr;
    static boolean[] isUsed;
    static Set<String> resultSet = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        Boj15663 process = new Boj15663();
        process.run();
    }

    public void run() throws IOException{
        init();
        func(0);
        for (String res : resultSet) {
            sb.append(res).append("\n");
        }
        System.out.println(sb.toString());
    }

    public void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        arr = new int[M];
        isUsed = new boolean[N];
        StringTokenizer ss = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(ss.nextToken());
        }
        Arrays.sort(num);
        }

    public void func(int cur) {
        if (M == cur) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < M; i++) {
                tmp.append(num[arr[i]]).append(" ");
            }
            String result = tmp.toString().trim();

            if (!resultSet.contains(result)) {
                resultSet.add(result);
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[cur] = i;
                func(cur+1);
                isUsed[i] = false;
            }
        }
    }

}

