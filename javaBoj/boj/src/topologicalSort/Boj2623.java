package topologicalSort;

import java.io.*;
import java.util.*;

class Boj2623 {

    static int N;
    static int M;

    static int[] indegree;

    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{
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
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());

            int parent = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n - 1; j++) {
                int child = Integer.parseInt(st.nextToken());
                graph.get(parent).add(child);
                indegree[child]++;
                parent = child;
            }
        }

    }

    private void sort() {
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if(indegree[i] == 0)
                que.offer(i);
        }

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int nxt : graph.get(cur)) {
                if (indegree[nxt] >= 0) {
                    indegree[nxt]--;
                    if (indegree[nxt] == 0) {
                        que.offer(nxt);
                    }
                }
            }
            sb.append(cur).append("\n");
            result.add(cur);
        }
        if (result.size() != N) {
            System.out.println(0);
            return;
        }
        System.out.println(sb.toString());

    }
}


