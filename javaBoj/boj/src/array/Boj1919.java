package array;

import java.util.*;
import java.io.*;

public class Boj1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bf.readLine();
        String str2 = bf.readLine();

        int[] lst1 = new int[26];
        int[] lst2 = new int[26];

        findArray(str1,lst1);
        findArray(str2,lst2);

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.abs(lst1[i] - lst2[i]);
        }
        System.out.println(result);
    }

    public static void findArray(String origin , int[] lst) {
        for (char c : origin.toCharArray()) {
            lst[c - 'a']++;
        }
    }

}
