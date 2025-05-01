package binarySearch;

import java.io.*;
import java.util.*;

public class Boj10816 {
    static int N;
    static int[] A;
    static int M;
    static int[] B;

    public static void main(String[] args) throws IOException{
        Boj10816 process = new Boj10816();
        process.run();
    }

    private void run() throws IOException {
        init();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int target : B) {
            int result = upper(target) - lower(target);
            System.out.println(result);
        }
    }

    private int lower(int target) {
        int st = 0;
        int end = A.length;

        while (st < end) {
            int mid = (st + end) / 2;
            if (A[mid] >= target) {
                end = mid;
            }else{
                st = mid + 1;
            }
        }

        return st;
    }

    private int upper(int target) {
        int st = 0;
        int end = A.length;

        while (st < end){
            int mid = (st + end) / 2;
            if (A[mid] > target) {
                end = mid;
            }else{
                st = mid + 1;
            }
        }

        return st;
    }

}



