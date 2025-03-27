package twopointer;

import java.io.*;
import java.util.*;



public class Boj2003 {
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        Boj2003 process = new Boj2003();
        process.run();
    }

    private void run() throws IOException {
        init();
        twoPointer();
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

    private void twoPointer() {
        int end = 0;
        int tot = arr[0];
        int cnt = 0;
        for (int st = 0; st < N; st++) {

            while (end < N && tot <= M) {
                if (tot == M) {
                    cnt++;
                }
                end++;
                if (end != N) {
                    tot += arr[end];
                }
            }

            if (end == N) {
                break;
            }


            tot -= arr[st];
        }

        System.out.println(cnt);
    }
}
