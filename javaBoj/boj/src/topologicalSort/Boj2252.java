package topologicalSort;

import java.io.*;
import java.util.*;

public class Boj2252 {
    static int N;
    static int M;

    static List<List<Integer>> graph;
    static List<Integer> result;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        Boj2252 process = new Boj2252();
        process.run();
    }

    private void run() throws IOException {
        init();
        topoSort();
        printResult();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N + 1];
        graph = new ArrayList<>();
        result = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            indegree[v]++;
        }

    }

    private void topoSort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i]==0) {
                queue.offer(i);
            }
        }


        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int nxt : graph.get(cur)) {
                if (indegree[nxt] > 0) {
                    indegree[nxt]--;
                    if (indegree[nxt] == 0) {
                        queue.offer(nxt);
                    }
                }
            }
            result.add(cur);
        }

    }

    private void printResult() {
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}
