package sort;

import java.util.*;
import java.io.*;


public class Boj11650 {
    static ArrayList<Pair> pairs = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        Boj11650 process = new Boj11650();

        process.run();

    }

    public void run() throws IOException {
        init();
        sortPair();
        printPair();
    }

    public void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pairs.add(new Pair(x, y));
        }

    }

    public void sortPair() {
        Collections.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.x == p2.x) {
                    return Integer.compare(p1.y, p2.y);
                }
                return Integer.compare(p1.x, p2.x);
            }
        });
    }

    public void printPair() {
        for (Pair pair : pairs) {
            System.out.println(pair.x + " " + pair.y);
        }
    }
}


class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}