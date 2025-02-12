package sort;

import java.util.*;
import java.io.*;

public class Boj2910 {
    static int N;
    static int C;
    static ArrayList<Pair> pairs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Boj2910 process = new Boj2910();
        process.run();

    }
    public void run() throws IOException {
        init();
        countSort();
        printSort();
    }

    public void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean contain = false;

            for (Pair pair : pairs) {
                if (pair.value == num) {
                    pair.count++;
                    contain = true;
                    break;
                }
            }
            if(!contain) {
                pairs.add(new Pair(num, 1, i));
            }
        }

    }

    public void countSort() {
        Collections.sort(pairs, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.count == p2.count) {
                    return Integer.compare(p1.index, p2.index);
                }
                return Integer.compare(p2.count, p1.count);
            }
        });
    }

    public void printSort() {
        StringBuilder sb = new StringBuilder();
        for (Pair pair : pairs) {
            sb.append((pair.value + " ").repeat(pair.count));
        }
        System.out.println(sb.toString().trim());
    }

    static class Pair {
        int value;
        int count;
        int index;

        public Pair(int value, int count,int index) {
            this.value = value;
            this.count = count;
            this.index = index;
        }

    }


}
