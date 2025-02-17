package greedy;

import java.util.*;
import java.io.*;



public class Boj15903 {

    static int N;
    static int M;
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        Boj15903 process = new Boj15903();
        process.run();
    }

    private void run() throws IOException{
        init();
        sumValue();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
             pq.add(Long.parseLong(st.nextToken()));
        }
    }

    private void sumValue() {
        long first = 0;

        while (M > 0) {
            if (!pq.isEmpty()) {
                first = pq.poll();
            }

            if (!pq.isEmpty() && M > 0) {
                long second = pq.poll();
                long value = first + second;
                pq.add(value);
                pq.add(value);
            }
            M--;
        }
        int ans = 0;
        for (Long l : pq) {
            ans += l;
        }

        System.out.println(ans);
    }




}
