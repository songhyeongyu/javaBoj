package priorityque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1715 {
    static PriorityQueue<Integer> pq;

    static int N;

    public static void main(String[] args) throws IOException {

        Boj1715 process = new Boj1715();
        process.run();

    }

    /**
     * 5
     * 73
     * 18
     * 14
     * 24
     * 12
     */

    private void run() throws IOException {
        init();
        calculateCard();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(bf.readLine()));
        }

    }

    private void calculateCard() {
        if (pq.size() == 1) {
            System.out.println(pq.poll());

            return;
        }

        int ans = 0;
        int temp = 0;
        while (true) {
            if (pq.size() == 1) {
                break;
            }
            if (pq.size() >= 2) {
                int first = pq.poll();
                int second = pq.poll();
                temp = first + second;
                ans += first + second;
                pq.add(temp);
            }

        }

        System.out.println(ans);


    }
}
