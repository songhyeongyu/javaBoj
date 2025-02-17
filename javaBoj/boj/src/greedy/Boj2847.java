package greedy;

import java.util.*;
import java.io.*;

public class Boj2847 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        Boj2847 process = new Boj2847();
        process.run();
    }

    private void run() throws IOException{
        init();
        makeFairLevel();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }


    }

    private void makeFairLevel() {
        int fair = 0;
        int standard = arr[arr.length - 1];

        for (int i = N-2; i > -1 ; i--) {
            if (arr[i] >= standard) {
                while (arr[i] >= standard) {
                    arr[i]--;
                    fair++;
                }
            }
            standard = arr[i];
        }
        System.out.println(fair);

    }


}
