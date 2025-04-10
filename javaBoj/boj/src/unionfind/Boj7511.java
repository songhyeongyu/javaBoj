package unionfind;

import java.util.*;
import java.io.*;

public class Boj7511 {
    static int T;
    static int N;
    static int K;
    static int[] p;

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Boj7511 process = new Boj7511();
        T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            process.run();
        }
    }

    private void run() throws IOException {
        init();
    }

    private void init() throws IOException {
        N = Integer.parseInt(bf.readLine()); // 몇개
        p = new int[N];
        Arrays.fill(p, -1);
        int m = Integer.parseInt(bf.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            union(parent, child);
            System.out.println(Arrays.toString(p));
        }

        int k = Integer.parseInt(bf.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) == find(b)) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }

        System.out.println(Arrays.toString(p));
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
