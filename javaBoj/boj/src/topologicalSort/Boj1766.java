package topologicalSort;

import java.io.*;
import java.util.*;

public class Boj1766 {
    static int N;
    static int M;
    static int[] indegree;
    static List<Integer> result;
    static List<List<Integer>> graph;



    public static void main(String[] args) throws IOException {
        Boj1766 process = new Boj1766();
        process.run();
    }

    private void run() throws IOException {
        init();
        func();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        graph = new ArrayList<>();
        result = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        indegree = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            graph.get(out).add(in);
            indegree[in]++;
        }

    }

    private void func() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }


        while (!pq.isEmpty()) {
            int cur = pq.poll();

            for (int nxt : graph.get(cur)) {
                if (indegree[nxt] > 0) {
                    indegree[nxt]--;
                    if (indegree[nxt] == 0) {
                        pq.offer(nxt);
                    }
                }
            }
            result.add(cur);
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }

    }


}
