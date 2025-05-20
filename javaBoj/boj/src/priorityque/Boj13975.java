package priorityque;

import java.io.*;
import java.util.*;

public class Boj13975 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException{
        Boj13975 process = new Boj13975();
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            process.run();
        }
    }

    private void run() throws IOException {
        init();
    }

    private void init() throws IOException {
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }
        int num = 0;
        while (pq.size() != 1) {
            long first = pq.poll();
            long second = pq.poll();
            num += first + second;
            pq.offer(first + second);
        }

        System.out.println(num);
    }
}
