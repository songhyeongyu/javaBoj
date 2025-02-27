package dynamicPrograming;

import java.io.*;


public class Boj2302 {
    static int N;
    static int T;
    static boolean[] seat;
    static int[] fibo;
    public static void main(String[] args) throws IOException{
        Boj2302 process = new Boj2302();
        process.run();
    }

    private void run() throws IOException{
        init();
        searchDp();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        seat = new boolean[N + 1];
        fibo = new int[N + 1];
        T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            int vip = Integer.parseInt(bf.readLine());
            seat[vip] = true;
        }

    }

    private void searchDp() {
        if (N == 1) {
            System.out.println(1);
            return;
        }
        fibo[0] = 1;
        fibo[1] = 1;

        for (int i = 2; i <= N; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        int count = 0;
        int ans = 1;
        for (int i = 1; i <= N; i++) {
            if (!seat[i]) {
                count++;
            }else{
                ans *= fibo[count];
                count = 0;

            }
        }

        if (count > 0) {
            ans *= fibo[count];
        }
        System.out.println(ans);
    }
}


