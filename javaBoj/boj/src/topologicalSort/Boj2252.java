package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2252 {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static int[] deg;

    public static void main(String[] args) throws IOException {
        Boj2252 process = new Boj2252();
        process.run();
    }

    private void run() throws IOException{
        init();
        findTopological();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        deg = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            deg[v] += 1;
            graph[u].add(v);
        }
    }


    private void findTopological() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (deg[i] == 0) {
                que.offer(i);
            }
        }
            while (!que.isEmpty()) {
                int cur = que.poll();
                System.out.print(cur + " ");
                for (int nxt : graph[cur]) {
                    deg[nxt]--;
                    if (deg[nxt] == 0) {
                        que.offer(nxt);
                    }
                }
            }
    }
}
