package sort;

import java.io.*;
import java.util.*;

public class Boj11656 {
    static ArrayList<String> strList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Boj11656 process = new Boj11656();
        process.run();

    }

    public void run() throws IOException{
        init();
        sortString();
        printResult();
    }

    public void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        StringBuilder sb = new StringBuilder();
        sliceString(input);
    }

    private static void sliceString(String input) {
        for (int i = input.length() -1; i > -1; i--) {
            strList.add(input.substring(i, input.length()));
        }
    }

    public void sortString() {
        Collections.sort(strList, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    public void printResult() {
        for (String string : strList) {
            System.out.println(string);
        }
    }
}
