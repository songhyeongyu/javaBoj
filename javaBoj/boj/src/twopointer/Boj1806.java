package twopointer;

import java.io.*;
import java.util.*;

public class Boj1806 {


    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        Boj1806 process = new Boj1806();
        process.run();
    }

    private void run() throws IOException {
        init();
        search();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }

    public void search() {
        int ed = 0;
        int tot = arr[0];
        int mn = Integer.MAX_VALUE;

        for (int st = 0; st < N; st++) {
            while (ed < N && tot < M) {
                ed++;
                if (ed != N) {
                    tot += arr[ed];
                }
                }
            if (ed == N) {
                break;
            }
            mn = Math.min(mn, ed - st + 1);
            tot -= arr[st];
        }

        if (mn == Integer.MAX_VALUE) {
            mn = 0;
        }
        System.out.println(mn);

    }



}
