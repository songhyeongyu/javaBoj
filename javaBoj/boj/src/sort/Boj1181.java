package sort;

import java.io.*;
import java.util.*;

public class Boj1181 {
    static Set<String> strings = new LinkedHashSet<>();
    static int N;

    public static void main(String[] args) throws IOException{
        Boj1181 process = new Boj1181();
        process.run();
    }

    private void run() throws IOException {
        init();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            strings.add(bf.readLine());
        }

        sortString();

    }

    private void sortString() {
        List<String> str = new ArrayList<>(strings);
        Collections.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }

        });

        for (String string : str) {
            System.out.println(string);
        }
    }

}
