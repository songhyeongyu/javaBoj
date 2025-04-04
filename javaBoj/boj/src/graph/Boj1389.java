package graph;

import java.io.*;
import java.util.*;

public class Boj1389 {
    static int N;
    static int M;
    static List<List<Integer>> graph;
    static boolean[] isUsed;

    static List<Node> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        Boj1389 process = new Boj1389();
        process.run();
    }

    private void run() throws IOException {
        init();

    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        isUsed = new boolean[N + 1];

        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            int result = 0;
            for (int j = 1; j <=N; j++) {
                result += bfs(i,j);
            }
            ans.add(new Node(i, result));
        }

        Collections.sort(ans, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.cnt == o2.cnt) {
                    return o1.cur - o2.cur;
                }
                return o1.cnt - o2.cnt;
            }
        });

        System.out.println(ans.getFirst().cur);
    }

    private int bfs(int begin, int target) {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(begin, 0));
        boolean[] visited = new boolean[N + 1];
        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (target == cur.cur) {
                return cur.cnt;
            }
            for (int nxt : graph.get(cur.cur)) {
                if (visited[nxt]) {
                    continue;
                }
                que.offer(new Node(nxt, cur.cnt + 1));
                visited[nxt] = true;
            }
        }
        return 0;
    }

    static class Node {
        int cur;
        int cnt;

        public Node(int cur, int cnt) {
            this.cur = cur;
            this.cnt = cnt;
        }
    }
}
