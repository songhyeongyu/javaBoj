package priorityque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2075 {

    static int N;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        Boj2075 process = new Boj2075();
        process.run();
    }

    private void run() throws IOException {
        init();
        findN();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(bf.readLine());
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                num *= -1;
                pq.add(num);
            }
        }


    }

    private void findN() {
        for (int i = 0; i < N-1; i++) {
            pq.poll();
        }

        System.out.println(pq.peek() * -1);

    }
}
