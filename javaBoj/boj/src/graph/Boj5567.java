package graph;

import java.io.*;
import java.util.*;

class Boj5567 {

    static int N;
    static int M;
    static int num;
    static List<List<Integer>> graph = new ArrayList<>();

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Boj5567 process = new Boj5567();
        process.run();
    }

    private void run() throws IOException {
        init();
        dfs(1);
        System.out.println(num - 1);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }


    }

    private void dfs(int cur) {
        visited[cur] = true;
        num++;
        for (int nxt : graph.get(cur)) {
            if (visited[nxt]) {
                continue;
            }
            dfs(nxt);
        }
    }
}
