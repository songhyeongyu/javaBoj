package graph;

import java.io.*;
import java.util.*;


public class Boj2606 {

    static int N;
    static int M;
    static boolean[] visit;
    static List<List<Integer>> virus;
    static int count;

    public static void main(String[] args) throws IOException{
        Boj2606 process = new Boj2606();
        process.run();
    }

    private void run() throws IOException{
        init();
        dfs(1);
        System.out.println(count-1);
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        virus = new ArrayList<>(N + 1);
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            virus.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            virus.get(u).add(v);
            virus.get(v).add(u);
        }

    }

    private void dfs(int cur) {
        visit[cur] = true;
        count++;
        for (int nxt : virus.get(cur)) {
            if (visit[nxt]) {
                continue;
            }
            dfs(nxt);
        }
    }
}
