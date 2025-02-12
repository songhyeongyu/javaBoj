package sort;


import java.util.*;
import java.io.*;

public class Boj1181 {
    static int N;
    static ArrayList<String> strList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Boj1181 process = new Boj1181();
        process.run();
    }

    public void run() throws IOException {
        init();
        sortStrList();
        printStrList();
    }

    public void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            if (strList.contains(input)) {
                continue;
            }
            strList.add(input);
        }
    }

    public void sortStrList() {
        Collections.sort(strList, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                return Integer.compare(s1.length(), s2.length());
            }
        });
    }

    public void printStrList() {
        for (String string : strList) {
            System.out.println(string);
        }
    }
}
