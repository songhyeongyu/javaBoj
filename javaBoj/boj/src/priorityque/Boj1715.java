package priorityque;

import java.io.*;
import java.util.*;

public class Boj1715 {

    static int N;
    static int num;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        Boj1715 process = new Boj1715();
        process.run();
    }

    private void run() throws IOException {
        init();
        makeCard();
        System.out.println(num);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            pq.offer(num);
        }
    }

    private void makeCard() {
        while (pq.size() != 1) {
            int first = pq.poll();
            int second = pq.poll();
            num += first + second;
            pq.offer(first+second);
        }

    }
}
