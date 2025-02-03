package deque;

import java.util.*;
import java.io.*;

public class Boj1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        Deque<Integer> choice = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            deque.offer(i);
        }
        StringTokenizer st2 = new StringTokenizer(bf.readLine());

        for (int i = 0; i < M; i++) {
            choice.offer(Integer.parseInt(st2.nextToken()));
        }
        int count = 0;

        while (!choice.isEmpty()) {
            int index = new ArrayList<>(deque).indexOf(choice.peekFirst());
            if (index <= deque.size() / 2) {
                int front = deque.pollFirst();
                if (front == choice.peekFirst()) {
                    choice.pollFirst();
                    continue;
                }
                deque.offerLast(front);
                count++;
            }else{
                int back = deque.pollLast();
                deque.offerFirst(back);
                count++;
            }
        }
        System.out.println(count);
    }
}
