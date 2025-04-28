package dynamicPrograming;

import java.util.*;
import java.io.*;

public class Boj9251 {
    static char[] str1;
    static char[] str2;

    static int[][] board;

    public static void main(String[] args) throws IOException {
        Boj9251 process = new Boj9251();
        process.run();
    }

    private void run() throws IOException {
        init();
        dp();
        System.out.println(board[str1.length -1][str1.length-1]);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s1 = bf.readLine();
        String s2 = bf.readLine();
        board = new int[s1.length()+1][s1.length()+1];
        str1 = new char[s1.length()+1];
        str2 = new char[s2.length()+1];
        for (int i = 1; i <= s1.length(); i++) {
            str1[i] = s1.charAt(i-1);
        }

        for (int i = 1; i <= s2.length(); i++) {
            str2[i] = s2.charAt(i-1);
        }
    }

    private void dp() {

        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str1.length; j++) {
                if (str1[i] == str2[j]) {
                    board[i][j] = board[i - 1][j - 1] + 1;
                }else{
                    board[i][j] = Math.max(board[i - 1][j], board[i][j - 1]);
                }
            }
        }
    }
}
