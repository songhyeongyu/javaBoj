package sort;

import java.io.*;
import java.util.*;

public class Boj11656 {
    static List<String> strings = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        Boj11656 process = new Boj11656();
        process.run();
    }

    private void run() throws IOException{
        String input = init();
        splitToken(input);
        sortStrings();
        printString();
    }

    private String init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        return bf.readLine();
    }

    private void splitToken(String input) {
        for (int i = 0; i < input.length() ; i++) {
            String result = input.substring(i);
            strings.add(result);
        }

    }

    private void sortStrings() {
        Collections.sort(strings,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    private void printString() {
        for (String string : strings) {
            System.out.println(string);
        }
    }


}
