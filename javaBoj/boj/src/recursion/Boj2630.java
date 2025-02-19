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

    private void run() throws IOException{
        init();
        System.out.println(oneCount);
        System.out.println(zeroCount);
    }

    private void init() throws IOException{
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

    private void func(int x,int y,int cur) {
        if (cur == 1 || isSame(x, y, cur) != 0) {
            int count = isSame(x, y, cur);
            if (paper[x][y] == 1) {
                oneCount += count;
            }else{
                zeroCount += count;
            }
        }

        int half = cur / 2;

        func(x, y, half);
        func(x + half, y, half);
        func(x, y + half, half);
        func(x + half, half + y, half);
    }

    private int isSame(int x, int y, int size) {
        int first = paper[x][y];
        int count = 0;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y+size; j++) {
                if (first != paper[i][j]) {
                    return 0;
                }
                count++;
            }
        }
        return count;
    }

}
