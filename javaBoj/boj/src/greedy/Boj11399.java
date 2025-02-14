package greedy;

import java.util.*;
import java.io.*;


public class Boj11399 {

    static int N;
    static int[] arr;
    static int[] atm;

    public static void main(String[] args) throws IOException{
        Boj11399 process = new Boj11399();
        process.run();
    }

    private void run() throws IOException{
        init();
        sumTime();
        printSum();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        atm = new int[Math.max(N + 1, 2)];
        arr = new int[Math.max(N + 1, 2)];

        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    private void sumTime() {
        atm[1] = arr[1];

        for (int i = 1; i <= N; i++) {
            atm[i] = atm[i - 1] + arr[i];
        }
    }

    private void printSum() {
        int sumVal = Arrays.stream(atm).sum();

        System.out.println(sumVal);
    }




}









































