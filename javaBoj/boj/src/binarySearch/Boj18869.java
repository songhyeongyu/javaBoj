package binarySearch;

import java.io.*;
import java.util.*;


public class Boj18869 {
    static int absMinVal = Integer.MAX_VALUE;
    static int N;
    static List<Integer> lst;

    //2
    public static void main(String[] args) throws IOException{
        Boj18869 process = new Boj18869();
        process.run();
    }

    private void run() throws IOException {
        init();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            lst.add(Integer.parseInt(st.nextToken()));
        }


    }
}
