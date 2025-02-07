package backTracking;

import java.io.*;
import java.util.*;
public class Boj15664 {
    static int N;
    static int M;
    static int[] num;
    static int[] arr;
    static Set<String> resultSet = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] isUsed;


    public static void main(String[] args) throws IOException{
        Boj15664 process = new Boj15664();
        process.run();
    }
    public void run() throws IOException {
        init();
        func(0,0);
        for (String res : resultSet) {
            sb.append(res).append("\n");
        }
        System.out.println(sb.toString());
    }

    public void init() throws IOException {
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

    public void func(int cur, int st) {
        if (M == cur) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < M; i++) {
                temp.append(num[arr[i]]).append(" ");
            }
            String result = temp.toString().trim();

            if (!resultSet.contains(result)) {
                resultSet.add(result);
            }
            return;
        }

        for (int i = st; i < N; i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                arr[cur] = i;
                func(cur + 1, i);
                isUsed[i] = false;
            }
        }
    }
}
