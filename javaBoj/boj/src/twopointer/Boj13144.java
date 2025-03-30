package twopointer;

import java.io.*;
import java.util.*;

public class Boj13144 {
    static int N;
    static int[] arr;
    static Set<Integer> temp;
    static int end;
    static int count;


    public static void main(String[] args) throws IOException {

        Boj13144 process = new Boj13144();
        process.run();
    }

    private void run() throws IOException {
        init();
        twoPoint(0, 0);
    }


    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        temp = new HashSet<>();
    }

    /**
     * 1,2,3,1,2
     * <p>
     * 1,2 1,2,3
     * <p>
     * 2,3 2,3,1
     * 3,1,2
     * 3,2
     * <p>
     * <p>
     * 1,2
     * 1,2,3
     * 1,2,3,2 x
     * 백트레킹 + 이분탐색인데?
     */


    private void twoPoint() {





    }





















}
