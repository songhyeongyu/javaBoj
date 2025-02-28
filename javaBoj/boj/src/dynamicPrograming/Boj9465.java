package dynamicPrograming;


import java.util.*;
import java.io.*;


public class Boj9465 {

    static int N;
    static int M;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        Boj9465 process = new Boj9465();
        N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            process.run();
        }

    }

    private void run() throws IOException{
        init();
    }

    private void init() throws IOException{
        M = Integer.parseInt(bf.readLine());
        int[][] arr = new int[2][M];
        int[][] dp = new int[3][M];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }
        findDp(arr, dp);
    }

    private void findDp(int[][]arr ,int[][] dp) {
        if(M == 1){
            System.out.println(Math.max(arr[0][0], arr[1][0]));
            return;
        }
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[0][1] = arr[1][0] + arr[0][1];
        dp[1][1] = arr[0][0] + arr[1][1];

        for (int i = 2; i < M; i++) {//dp[0][i-1]아무것도 선택 x -> dp[1][i-1] 1행 선택 dp[0][i-2]0행선택
                dp[0][i] =  Math.max(Math.max(dp[0][i - 2],dp[1][i-2]),dp[1][i-1]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1], Math.max(dp[0][i - 2],dp[1][i-2])) + arr[1][i];
        }
        int max = Math.max(dp[0][M - 1], dp[1][M - 1]);
        System.out.println(max);

    }
}
