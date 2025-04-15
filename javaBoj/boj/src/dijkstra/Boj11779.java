package dijkstra;

import java.io.*;
import java.util.*;

public class Boj11779 {
    static int N;
    static int M;

    static int[] dist;
    static int[] pre;

    static int start;
    static int end;

    static List<List<Node>> graph;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        Boj11779 process = new Boj11779();
        process.run();
    }

    private void run() throws IOException {
        init();
        dijkstra();
        printResult();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        graph = new ArrayList<>();
        result = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(w, v));
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        pre = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
    }

    private void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, start));
        dist[start] = 0;


        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.dst] < cur.cost) {
                continue;
            }
            for (Node nxt : graph.get(cur.dst)) {
                int newDist = nxt.cost + dist[cur.dst];
                if (newDist < dist[nxt.dst]) {
                    dist[nxt.dst] = newDist;
                    pq.offer(new Node(dist[nxt.dst], nxt.dst));
                    pre[nxt.dst] = cur.dst;
                }
            }
        }

    }

    private void printResult() {
        System.out.println(dist[end]);
        int cur = end;
        while (cur != start) {
            result.add(cur);
            cur = pre[cur];
        }
        result.add(start);
        System.out.println(result.size());
        Collections.reverse(result);

        for (Integer integer : result) {
            System.out.print(integer + " ");
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
        public int compareTo(Node n1) {
            return Integer.compare(this.cost, n1.cost);
        }
    }
}
