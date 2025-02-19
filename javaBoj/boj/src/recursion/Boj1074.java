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

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int ans = func(N, r, c);

    }

    private int func(int n,int r,int c) {
        if (n == 0) {
            return 0;
        }

        return 0;
    }
}
