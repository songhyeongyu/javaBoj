package dynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1904 {

    static int N;
    static long[] d;

    public static void main(String[] args) throws IOException {
        Boj1904 process = new Boj1904();
        process.run();
    }

    private void run() throws IOException {
        init();
        dp();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        d = new long[Math.max(N + 1, 4)];
    }

    private void dp() {
        d[1] = 1;
        d[2] = 2;

        for (int i = 3; i <= N; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 15746;
        }
        System.out.println(d[N]);
    }


}
