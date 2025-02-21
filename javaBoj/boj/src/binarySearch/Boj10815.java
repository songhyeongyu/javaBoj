package binarySearch;

import java.io.*;
import java.util.*;

public class Boj10815 {

    static int N;
    static int M;
    static int[] arr;
    static int[] targetArr;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Boj10815 process = new Boj10815();
        process.run();
    }

    private void run() throws IOException {
        init();
        SearchTarget();
        System.out.println(sb.toString());
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(bf.readLine());
        targetArr = new int[M];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < M; i++) {
            targetArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }

    private void SearchTarget() {
        for (int i = 0; i < M; i++) {
            int num = binarySearch(targetArr[i]);
            sb.append(num).append(" ");
        }

    }

    private int binarySearch(int target) {
        int index = Arrays.binarySearch(arr, target);

        if (index < 0) {
            return 0;
        }else {
            return 1;
        }
    }

}
