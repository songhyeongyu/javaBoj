package priorityque;

import java.io.*;
import java.util.*;

public class Boj11286 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            int idx = 1;
            if (num != 0) {
                if (num < 0) {
                    idx = -1;
                }
                num = Math.abs(num);
                pq.offer(new Node(num, idx));
            }

            else{
                if (pq.isEmpty()) {
                    System.out.println(0);
                }else{
                    Node cur = pq.peek();

                    if (cur.idx < 0) {
                        Node p = pq.poll();
                        System.out.println(p.n * p.idx);
                    }else{
                        Node p = pq.poll();
                        System.out.println(p.n);
                    }
                }
            }

        }
    }

    static class Node implements Comparable<Node>{

        int n;
        int idx;

        public Node(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            if (this.n == o.n) {
                return Integer.compare(this.idx, o.idx);
            }
            return Integer.compare(this.n, o.n);
        }
    }

}

