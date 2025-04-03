package graph;


import java.io.*;
import java.util.*;


public class Boj1260 {
    static int N;
    static int M;
    static int V;
    static List<List<Integer>> graph;
    static boolean[] isUsedDfs;
    static boolean[] isUsedBfs;
    static StringBuilder sbDfs = new StringBuilder();
    static StringBuilder sbBfs = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Boj1260 process = new Boj1260();
        process.run();
    }

    private void run() throws IOException {
        init();
        dfs(V);
        bfs(V);
        System.out.println(sbDfs.toString());
        System.out.println(sbBfs.toString());
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        isUsedDfs = new boolean[N + 1];
        isUsedBfs = new boolean[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
        sbDfs.append(V).append(" ");

    }

    private void dfs(int cur) {
        if (isUsedDfs[cur]) {
            return;
        }
        isUsedDfs[cur] = true;

        for (int nxt : graph.get(cur)) {
            if (isUsedDfs[nxt]) {
                continue;
            }
            sbDfs.append(nxt).append(" ");
            dfs(nxt);
        }
    }

    private void bfs(int cur) {

        Queue<Integer> que = new LinkedList<>();
        que.offer(cur);
        isUsedBfs[cur] = true;

        while (!que.isEmpty()) {
            int n = que.poll();
            sbBfs.append(n).append(" ");
            for (int nxt : graph.get(n)) {
                if (isUsedBfs[nxt]) {
                    continue;
                }
                que.offer(nxt);
                isUsedBfs[nxt] = true;
            }

        }

    }

}


