package priorityque;

import java.io.*;
import java.util.*;

public class Boj11279 {
    static int N;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Boj11279 process = new Boj11279();

        process.run();
    }

    private void run() throws IOException {
        init();
        findMaxHeap(N);
    }

    private void init() throws IOException {

        N = Integer.parseInt(bf.readLine());
    }

    private void findMaxHeap(int n) throws IOException{
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll() * -1);
                }
            }
            else{
                pq.add(num * -1);
            }
        }
    }


}
