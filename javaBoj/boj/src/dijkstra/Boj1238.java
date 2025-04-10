package dijkstra;

import java.util.*;
import java.io.*;

public class Boj1238 {
    static List<List<Node>> graph = new ArrayList<>();
    static PriorityQueue<Node> pq;
    static int[] dist;

    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int M;
    static int X;

    public static void main(String[] args) throws IOException {
        Boj1238 process = new Boj1238();
        process.run();
    }

    private void run() throws IOException {
        init();
        iterFriend();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());



        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(c, e));
        }

        //start지점을 정해놓고 계속 돌린다.
    }

    private void dijkstra(int start) {
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        pq = new PriorityQueue<>();


        pq.offer(new Node(0, start));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.dst] < cur.cost) {
                continue;
            }

            for (Node nxt : graph.get(cur.dst)) {
                int newDist = dist[cur.dst] + nxt.cost;
                if (dist[nxt.dst] > newDist) {
                    dist[nxt.dst] = newDist;
                    pq.offer(new Node(newDist, nxt.dst));
                }
            }
        }
    }

    private void iterFriend() {
        for (int i = 1; i <= N; i++) {
            dijkstra(i);
            System.out.println(Arrays.toString(dist));
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
        public int compareTo(Node o) {
            return Integer.compare(this.cost,o.cost);
        }
    }
}
