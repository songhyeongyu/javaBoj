package dynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj9251 {
    static String s1;
    static String s2;

    static int[][] lcs;

    public static void main(String[] args) throws IOException {
        Boj9251 process = new Boj9251();
        process.run();
    }

    private void run() throws IOException {
        init();
        makeLcs();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        s1 = bf.readLine();
        s2 = bf.readLine();

        lcs = new int[s1.length() + 1][s2.length() + 1];

    }

    private void makeLcs() {
        char[] originS1 = s1.toCharArray();
        char[] originS2 = s2.toCharArray();

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (originS1[i - 1] == originS2[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                }else{
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        System.out.println(Arrays.deepToString(lcs));

    }
}
