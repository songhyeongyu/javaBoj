package topologicalSort;

import java.io.*;
import java.util.*;

public class Boj2623 {
    static int N;
    static int M;
    static int[] indegree;
    static Queue<Integer> queue;
    static List<Integer> result;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        Boj2623 process = new Boj2623();
        process.run();
    }

    private void run() throws IOException {
        init();
        sort();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        graph = new ArrayList<>();
        queue = new LinkedList<>();
        result = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int t = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            for (int j = 0; j < t-1; j++) {
                int second = Integer.parseInt(st.nextToken());
                graph.get(first).add(second);
                first = second;
                indegree[second]++;
            }
        }

    }

    private void sort() {
        for (int i = 1 ; i <=N; i++) {
            if (indegree[i] == 0) {
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

        if (result.size() != N) {
            System.out.println(0);
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
