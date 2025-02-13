package greedy;

import java.util.*;
import java.io.*;

public class Boj1026 {
    static int N;
    static int[] A;
    static Integer[] B;
    public static void main(String[] args) throws IOException{
        Boj1026 process = new Boj1026();
        process.run();
    }

    private void run() throws IOException{
        init();
        sumAnswer();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        A = new int[N];
        B = new Integer[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(B, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
    }

    private void sumAnswer() {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += A[i] * B[i];
        }

        System.out.println(sum);
    }
}
