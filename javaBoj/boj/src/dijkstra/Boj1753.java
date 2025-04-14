package dijkstra;

import java.io.*;
import java.util.*;

public class Boj1753 {
    static List<List<Node>> graph;
    static int N;
    static int M;
    static int K;
    static int[] dist;
    private final static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        Boj1753 process = new Boj1753();
        process.run();
    }

    private void run() throws IOException {
        init();
        dijkstra();
        printResult();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(bf.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(w, v));
        }

        dist = new int[N + 1];
        Arrays.fill(dist, INF);
    }

    private void dijkstra() {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(0, K));
        dist[K] = 0;
        while (!que.isEmpty()) {
            Node cur = que.poll();

            if (dist[cur.dst] < cur.cost) {
                continue;
            }

            for (Node nxt : graph.get(cur.dst)) {
                int nextDist = nxt.cost + dist[cur.dst];
                if (nextDist < dist[nxt.dst]) {
                    dist[nxt.dst] = nextDist;
                    que.offer(new Node(dist[nxt.dst], nxt.dst));
                }
            }
        }

    }

    private void printResult() {
        for (int i = 1; i <= N; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }
    }

    static class Node implements Comparable<Node>{
        int cost;
        int dst;

        public Node(int cost, int dst) {
            this.cost = cost;
            this.dst = dst;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.cost, node.cost);
        }
    }
}
