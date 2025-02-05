package recursion;

import java.io.*;
import java.util.*;

public class Boj1074 {

    public static void main(String[] args) throws IOException{
        Boj1074 process = new Boj1074();
        process.run();

    }

    public void run() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans = func(N, r, c);
        System.out.print(ans);
    }

    public int func(int n, int r, int c) {
        if(n==0) return 0;

        int half = 1 << (n - 1);

        if (r < half && c < half) {
            return func(n-1,r,c);
        }
        if (r < half && c >= half) {
            return half * half + func(n - 1, r, c - half);
        }

        if (r >= half && c < half) {
            return 2 * half * half + func(n - 1, r - half, c);
        }

        return 3 * half * half + func(n - 1, r - half, c - half);

    }
}
