package binarySearch;

import java.io.*;
import java.util.*;

public class Boj10816 {
    static int N;
    static int M;
    static int[] arr;
    static int[] targetArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        Boj10816 process = new Boj10816();
        process.run();

    }

    private void run() throws IOException {
        init();
        for (int i = 0; i < M; i++) {
            binarySearch(targetArr[i]);
        }
        System.out.println(sb.toString());
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(bf.readLine());
        targetArr = new int[M];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            targetArr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void binarySearch(int target) {
        int st = 0;
        int ed = arr.length - 1;

        while (st <= ed) {
            int mid = (st + ed) / 2;

            if (target > arr[mid]) {
                st = mid + 1;
            } else if (target < arr[mid]) {
                ed = mid - 1;
            }else{
                int ans = find(mid);
                sb.append(ans).append(" ");
                return;
            }
        }
        sb.append(0).append(" ");
    }

    private int find(int mid) {
        int rCount = 0;
        int lCount = 0;
        for (int i = mid; i < arr.length; i++) {
            if (arr[i] == arr[mid]) {
                rCount++;
            }
        }

        for (int i = 0; i < mid; i++) {
            if (arr[i] == arr[mid]) {
                lCount++;
            }
        }
        int count = rCount + lCount;

        return count;
    }


}



