package recursion;

import java.io.*;
import java.util.*;

public class Boj2630 {
    static int N;
    static int[][] paper;
    static int oneCount;
    static int zeroCount;

    public static void main(String[] args) throws IOException {

        Boj2630 process = new Boj2630();

        process.run();
    }

    private void run() throws IOException {
        init();
        recursion(0,0,N);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                paper[i][j] = n;
            }
        }


    }

    private void recursion(int x, int y, int n) {

        if (isSame(x, y, n)) {
            int first = paper[x][y];
            if (first == 1) {
                oneCount += 1;
            } else {
                zeroCount += 1;
            }
            return;
        }
        int half = n / 2;
        recursion(x, y, n / 2);
        recursion(x, y + half, n / 2);
        recursion(x + half, y, n / 2);
        recursion(x + half, y + half, n / 2);


    }

    private boolean isSame(int x, int y, int n) {
        int first = paper[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (first != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


}
