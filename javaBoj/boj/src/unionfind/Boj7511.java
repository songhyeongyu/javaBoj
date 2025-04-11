package unionfind;

import java.io.*;
import java.util.*;

public class Boj7511 {
    static int T;
    static int N;
    static int[] p;

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        Boj7511 process = new Boj7511();
        T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            System.out.println("Scenario " + (i+1) + ":");
            process.run();
            System.out.println();
        }
    }

    private void run() throws IOException {
        init();
    }

    private void init() throws IOException {

        N = Integer.parseInt(bf.readLine());
        p = new int[N + 1];
        Arrays.fill(p, -1);

        int m = Integer.parseInt(bf.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            union(u, v);
        }

        int k = Integer.parseInt(bf.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (find(u) == find(v)) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    private int find(int x) {
        if (p[x] < 0) {
            return x;
        }
        return p[x] = find(p[x]);
    }

    private boolean union(int u, int v) {
        u = find(u);
        v = find(v);

        if (u == v) {
            return false;
        }
        if (p[v] < p[u]) {
            int temp = u;
            u = v;
            v = temp;
        }
        if (p[u] == p[v]) {
            p[u]--;
        }
        p[v] = u;
        return true;

    }
}
