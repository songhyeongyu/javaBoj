package dynamicPrograming;

import java.io.*;
import java.util.Arrays;


public class Boj9461 {
    static int N;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static long[] d;
    public static void main(String[] args) throws IOException{
        Boj9461 process = new Boj9461();
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            process.run();
        }
    }

    private void run() throws IOException{
        init();
        dp();
    }

    private void init() throws IOException {
        N = Integer.parseInt(bf.readLine());
        d = new long[Math.max(4, N + 1)];
    }

    private void dp() {
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;

        for (int i = 4; i <= N; i++) {
            d[i] = d[i - 2] + d[i - 3];
        }

        System.out.println(d[N]);
    }
}
