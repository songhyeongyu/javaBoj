package unionfind;

import java.io.*;
import java.util.*;

class Boj1717 {

    static int N;
    static int M;

    static int[] p;

    public static void main(String[] args) throws IOException{
        Boj1717 process = new Boj1717();
        process.run();

    }

    private void run() throws IOException {
        init();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        Arrays.fill(p,-1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                if (find(u) == find(v)) {
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

            else{
                union(u, v);
            }
        }
    }


    private int find(int x) {
        if (p[x] < 0) {
            return x;
        }
        return find(p[x]);
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


