package binarySearch;

import java.io.*;
import java.util.*;

public class Boj18870 {
    static int N;
    static int[] arr;
    static Set<Integer> bArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        Boj18870 process = new Boj18870();
        process.run();

    }

    private void run() throws IOException {
        init();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        bArr = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            bArr.add(num);
        }

        List<Integer> sortedList = new ArrayList<>(bArr);
        Collections.sort(sortedList);

        for (int i = 0; i < N; i++) {
            int ans = Collections.binarySearch(sortedList, arr[i]);
            sb.append(ans).append(" ");
        }

        System.out.println(sb.toString());
    }


}



