package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj15665 {

    static int N;
    static int M;
    static int[] num;
    static int[] arr;
    static Set<String> resultSet = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();




    public static void main(String[] args) throws IOException{
        Boj15665 process = new Boj15665();
        process.run();
    }

    public void run() throws IOException {
        init();
        func(0);
        for (String s : resultSet) {
            sb.append(s).append("\n");
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
        StringTokenizer ss = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(ss.nextToken());
        }
        Arrays.sort(num);
    }

    public void func(int cur) {
        if (cur == M) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < M; i++) {
                s.append(num[arr[i]]).append(" ");
            }
            String input = s.toString().trim();

            if (!resultSet.contains(input)) {
                resultSet.add(input);
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            arr[cur] = i;
            func(cur+1);
        }

    }
}
