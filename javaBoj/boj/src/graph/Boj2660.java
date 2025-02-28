package graph;

import java.io.*;
import java.util.*;


public class Boj2660 {
    static int N;
    static List<List<Integer>> friend;
    static boolean[][] visited;
    static List<int[]> friendShip = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException{
        Boj2660 process = new Boj2660();
        process.run();
    }

    private void run() throws IOException{
        init();
        bfs(0);
        System.out.println(findMinDepth() + " " + countMinDepth());
        System.out.println(sb.toString());
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        friend = new ArrayList<>(N + 1);
        visited = new boolean[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            friend.add(new ArrayList<>());
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (u == -1 && v == -1) {
                break;
            }

            friend.get(u).add(v);
            friend.get(v).add(u);
        }


    }

    private void bfs(int depth) {


        for (int i = 1; i <= N; i++) {
            visited[i][i] = true;
            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{i,depth});
            int count = 0;
            while (!que.isEmpty()) {
                int[] cur = que.poll();
                count = Math.max(count, cur[1]);
                for (int nxt : friend.get(cur[0])) {
                    if (visited[i][nxt]) {
                        continue;
                    }

                    visited[i][nxt] = true;
                    que.offer(new int[]{nxt,cur[1] + 1});
                }
            }
            friendShip.add(new int[]{i,count});
        }
    }

    private int findMinDepth() {
        int min = Integer.MAX_VALUE;
        for (int[] depth : friendShip) {
            min = Math.min(depth[1], min);
        }

        return min;
    }

    private int countMinDepth() {
        int count = 0;
        for (int[] ints : friendShip) {
            if (ints[1] == findMinDepth()) {
                sb.append(ints[0]).append(" ");
                count++;
            }
        }
        return count;
    }




    static class Node{
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

}
