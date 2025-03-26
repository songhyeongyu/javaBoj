package binarySearch;

import java.io.*;
import java.util.*;


public class Boj18869 {
    static int N;
    static int M;
    static int[][] universe;
    static List<Integer>[] uni;

    public static void main(String[] args) throws IOException{
        Boj18869 process = new Boj18869();
        process.run();

    }

    private void run() throws IOException{
        init();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        universe = new int[N][M];
        uni = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            uni[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                universe[i][j] = num;
                uni[i].add(num);
            }
        }

        List<List<Integer>> uniList = new ArrayList<>();
        for (int i = 0; i < universe.length; i++) {
            Collections.sort(uni[i]);
            uniList.add(uni[i]);
        }

        uniList = new ArrayList<>(new LinkedHashSet<>(uniList));
        System.out.println(Arrays.deepToString(uniList.toArray()));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
//                int ans = Collections.binarySearch(uniList.get(i));

            }
        }
    }

    private int compareNum(int a, int b) {
        if (a > b) {
            return 1;
        } else if (a == b) {
            return 0;
        }else{
            return -1;
        }
    }


}
