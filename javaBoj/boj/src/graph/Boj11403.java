package graph;

import java.io.*;
import java.util.*;

public class Boj11403 {
    static int N;
    static List<List<Integer>> graph;
    static int[][] visit;
    public static void main(String[] args) throws IOException{
        Boj11403 process = new Boj11403();
        process.run();
    }

    private void run() throws IOException{
        init();
        bfs();
        printResult();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N ; i++) {
            graph.add(new ArrayList<>());
        }
        visit = new int[N][N];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    graph.get(i).add(j);
                }
            }
        }
    }

    private void bfs() {
        for (int i = 1; i <= N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int nxt : graph.get(cur)) {
                    if(visit[i-1][nxt-1] == 0) {
                        visit[i-1][nxt-1] = 1;
                        queue.add(nxt);
                    }
                }

            }
        }
    }

    private void printResult() {
        for (int[] ints : visit) {
            StringBuilder sb = new StringBuilder();
            for (int num : ints) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
