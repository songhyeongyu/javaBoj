package binarySearch;

import java.io.*;
import java.util.*;

public class Boj1920 {
    static int N;
    static List<Integer> A = new ArrayList<>();
    static int M;
    static List<Integer> B = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        Boj1920 process = new Boj1920();
        process.run();
    }

    private void run() throws IOException {
        init();
        findNum();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < M; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(A);


    }

    private void findNum() {
        for (Integer integer : B) {
            int res = b(integer);
            System.out.println(res);
        }
    }

    private int binary(int target) {
        int result = Collections.binarySearch(A, target);
        if (result >= 0) {
            return 1;
        }
        return 0;
    }

    private int b(int target) {
        int st = 0;
        int end = A.size() - 1;

        while (st <= end) {
            int mid = (st + end) / 2;
            if (target > A.get(mid)) {
                st = mid + 1;
            } else if (target < A.get(mid)) {
                end = mid - 1;
            } else if (target == A.get(mid)) {
                return 1;
            }
        }



        return 0;
    }
}