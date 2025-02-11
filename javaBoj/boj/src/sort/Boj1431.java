package sort;

import java.util.*;
import java.io.*;


public class Boj1431 {
    static ArrayList<String> strArr = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        Boj1431 process = new Boj1431();

        process.run();

    }

    private void run() throws IOException {
        init();
        sortString();
        printResult();
    }

    public void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            strArr.add(bf.readLine());
        }
    }

    public void sortString() {
        Collections.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int length1 = s1.length();
                int length2 = s2.length();

                if (length1 == length2) {
                    int s1Value = compareSum(s1);
                    int s2Value = compareSum(s2);

                    if (s1Value == s2Value) {
                        return s1.compareTo(s2);
                    }
                    return Integer.compare(s1Value, s2Value);
                }
                return Integer.compare(length1, length2);
            }



        });
    }
    private static int compareSum(String s1) {
        int sumVal = 0;
        for (char c : s1.toCharArray()) {
            if (Character.isDigit(c)) {
                sumVal += c - '0';
            }
        }
        return sumVal;
    }

    public void printResult() {
        for (String string : strArr) {
            System.out.println(string);
        }
    }

}
