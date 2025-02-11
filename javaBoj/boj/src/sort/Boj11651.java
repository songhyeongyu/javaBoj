package sort;

import java.util.*;
import java.io.*;


public class Boj11651 {
    static int N;
    static ArrayList<Pair> lst = new ArrayList<>();
    public static void main(String[] args) throws IOException{

        Boj11651 process = new Boj11651();
        process.run();

    }

    public void run() throws IOException {
        init();
        sortLst();
        printResult();
    }

    public void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lst.add(new Pair(x, y));
        }
    }

    public void sortLst() {
        Collections.sort(lst, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if (p1.y == p2.y) {
                    return Integer.compare(p1.x, p2.x);
                }
                return Integer.compare(p1.y, p2.y);
            }
        });
    }

    public void printResult() {
        for (Pair pair : lst) {
            System.out.println(pair.x + " " + pair.y);
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
