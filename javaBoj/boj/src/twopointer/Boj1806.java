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
        arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private void search() {
        int tot = arr[0];
        int min = Integer.MAX_VALUE;
        int ed = 0;

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
            min = Math.min(min, ed - st + 1);
            tot -= arr[st];
        }

        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        System.out.println(min);

    }

}
