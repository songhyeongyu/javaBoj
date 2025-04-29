package dynamicPrograming;

import java.util.*;
import java.io.*;

public class Boj9251 {
    static char[] src;
    static char[] dst;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        Boj9251 process = new Boj9251();
        process.run();
    }

    private void run() throws IOException {
        init();
        dynamic();
        System.out.println(dp[src.length-1][dst.length-1]);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str1 = bf.readLine();
        String str2 = bf.readLine();
        src = new char[str1.length()+1];
        dst = new char[str2.length()+1];
        for (int i = 1; i <= str1.length(); i++) {
            src[i] = str1.charAt(i-1);
        }

        for (int i = 1; i <= str2.length(); i++) {
            dst[i] = str2.charAt(i-1);
        }
        dp = new int[str1.length() + 1][str2.length() + 1];
    }

    private void dynamic() {

        for (int i = 1; i < src.length; i++) {
            for (int j = 1; j < dst.length; j++) {
                if (src[i] == dst[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

    }
}
