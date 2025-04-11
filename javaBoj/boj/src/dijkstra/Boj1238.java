package dijkstra;

import java.io.*;
import java.util.*;

public class Boj1238 {
    static int N;
    static int M;
    static int X;

    static List<List<Node>> graph;
    static List<List<Node>> reverse;

    static int[] dist;
    static int[] distR;


    public static void main(String[] args) throws IOException {
        Boj1238 process = new Boj1238();
        process.run();
    }

    private void run() throws IOException {
        init();
        dist = dijkstra(graph, dist, X);
        distR = dijkstra(reverse, distR, X);
        int ans = findAnswer();
        System.out.println(ans);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        reverse = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(t, v));
            reverse.get(v).add(new Node(t, u));
        }
    }

    private int[] dijkstra(List<List<Node>> g, int[] d, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d = new int[N + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        pq.offer(new Node(0, x));
        d[x] = 0;


        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (d[cur.dst] < cur.cost) {
                continue;
            }

            for (Node nxt : g.get(cur.dst)) {
                int newDist = d[cur.dst] + nxt.cost;
                if (newDist < d[nxt.dst]) {
                    d[nxt.dst] = newDist;
                    pq.offer(new Node(newDist, nxt.dst));
                }
            }

        }

        return d;
    }

    private int findAnswer() {
        int count = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            count = Math.max(dist[i] + distR[i], count);
        }

        return count;
    }

    static class Node implements Comparable<Node> {
        int cost;
        int dst;

        public Node(int cost, int dst) {
            this.cost = cost;
            this.dst = dst;
        }

        @Override
        public int compareTo(Node o1) {
            return Integer.compare(this.cost, o1.cost);
        }
    }
}
