package graph;

import java.io.*;
import java.util.*;

class Boj5567 {

    static int N;
    static int M;
    int num;

    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        Boj5567 process = new Boj5567();
        process.run();
    }

    private void run() throws IOException{
        init();
        bfs();
        System.out.println(num - 1);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

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

    private void bfs() {
        Queue<Node> que = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        que.offer(new Node(1, 0));
        visited[1] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            num++;
            for (int nxt : graph.get(cur.x)) {
                if (visited[nxt] || cur.depth >= 2) {
                    continue;
                }
                visited[nxt] = true;
                que.offer(new Node(nxt, cur.depth + 1));
            }
        }

    }

    static class Node{

        int x;
        int depth;

        public Node(int x, int depth) {
            this.x = x;
            this.depth = depth;
        }
    }
}
