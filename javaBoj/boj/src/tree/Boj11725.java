package tree;


import java.util.*;
import java.io.*;

public class Boj11725 {
    static int N;
    static List<Integer>[] graph;
    static int[] p;

    public static void main(String[] args) throws IOException{
        Boj11725 process = new Boj11725();
        process.run();
    }

    private void run() throws IOException {
        init();
        findRootByDfs(1);
        printResult();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        graph = new ArrayList[N + 1];
        p = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1 ; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

    }

//    private void findRoot(int start) {
//        Queue<Integer> que = new LinkedList<>();
//
//        que.offer(start);
//
//        while (!que.isEmpty()) {
//            int cur = que.poll();
//
//            for (int nxt : graph[cur]) {
//                if (p[cur] == nxt) {
//                    continue;
//                }
//                p[nxt] = cur;
//                que.offer(nxt);
//            }
//        }
//    }

    private void findRootByDfs(int start) {
        for (int nxt : graph[start]) {
            if (p[start] == nxt) {
                continue;
            }
            p[nxt] = start;
            findRootByDfs(nxt);
        }
    }

    private void printResult() {
        for (int i = 2; i <= N; i++) {
            System.out.println(p[i]);
        }
    }

}
