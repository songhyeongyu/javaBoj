package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1822 {

    static int N;
    static int M;

    static int[] A;
    static int[] B;

    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Boj1822 process = new Boj1822();
        process.run();

    }

    private void run() throws IOException {
        init();
        if (findElement()) {
            System.out.println(count);
            System.out.println(sb.toString());
        }else{
            System.out.println(0);
        }

    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(B);
        Arrays.sort(A);
    }

    private boolean findElement() {
        boolean isSuccess = false;
        for (int i = 0; i < N; i++) {
            boolean flag = binarySearch(A[i]);
            if (!flag) {
                count++;
                sb.append(A[i]).append(" ");
                isSuccess = true;
            }
        }
        return isSuccess;
    }

    private boolean binarySearch(int target) {
        int index = Arrays.binarySearch(B, target);

        if (index < 0) {
            return false;
        }
        return true;
    }
}
