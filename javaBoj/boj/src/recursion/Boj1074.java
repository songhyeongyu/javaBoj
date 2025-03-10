package recursion;

import java.io.*;
import java.util.*;

public class Boj1074 {
    static int N;
    static int r;
    static int c;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        Boj1074 process = new Boj1074();

        process.run();
    }

    private void run() throws IOException {
        init();
    }
    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = 1 << N;

        arr = new int[size][size];
        System.out.println(func(r, c, N));

    }

    private int func(int x, int y, int n) {
        if (n == 0) {
            return 0;
        }

        int half = 1 << (n - 1);


        if (x < half && y < half) {
            return func(x, y, n-1);
        }

        if (x < half && y > half) {
            return 2 * 3 +func(x, y-half, n - 1);
        }

        if (x > half && y < half) {
            return 2 + 3 * func(x-half, y, n - 1);
        }

        return 3 + 4*func(x-half, y-half, n-1);

    }
}
