package graph;

import java.io.*;
import java.util.*;

class Boj2660 {

    static int N;
    static List<List<Integer>> graph = new ArrayList<>();
    static List<Node> result = new ArrayList<>();


    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (u == -1 && v == -1) {
                break;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        bfs();
        printAnswer();

    }

    private static void bfs() {

        boolean[] visited;
        for (int i = 1; i <= N; i++) {
            Queue<Node> que = new LinkedList<>();
            visited= new boolean[N+1];

            que.offer(new Node(i, 0));
            visited[i] = true;
            int now = 0;
            while (!que.isEmpty()) {
                Node cur = que.poll();

                for (int nxt : graph.get(cur.x)) {
                    if (visited[nxt]) {
                        continue;
                    }
                    visited[nxt] = true;
                    now = cur.depth + 1;
                    que.offer(new Node(nxt, now));
                }

            }
            result.add(new Node(i, now));
        }

    }

    private static void printAnswer() {
        Collections.sort(result,(n1,n2) ->{
            if (n1.depth == n2.depth) {
                return Integer.compare(n1.x, n2.x);
            }
            return Integer.compare(n1.depth, n2.depth);
        });

        int value = result.get(0).depth;
        List<Integer> num = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Node node : result) {
            if (node.depth == value) {
                num.add(node.x);
                sb.append(node.x).append(" ");
            }
            else{
                break;
            }
        }

        System.out.println(value + " " + num.size());
        System.out.println(sb.toString());

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


