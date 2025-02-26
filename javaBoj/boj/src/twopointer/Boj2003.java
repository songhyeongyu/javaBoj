package twopointer;

import java.io.*;
import java.util.*;



public class Boj2003 {

    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        Boj2003 process = new Boj2003();
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
    }

    private void search() {
        int ed = 0;
        int tot = arr[0];
        int count = 0;
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
            if (tot == M) {
                count++;
            }
            tot -= arr[st];
        }
        System.out.println(count);
    }
}
