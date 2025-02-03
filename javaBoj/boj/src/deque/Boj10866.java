package deque;

import java.util.*;
import java.io.*;

public class Boj10866 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push_front")) {
                int element = Integer.parseInt(st.nextToken());
                deque.offerFirst(element);
            } else if (cmd.equals("push_back")) {
                int element = Integer.parseInt(st.nextToken());
                deque.offerLast(element);
            } else if (cmd.equals("pop_front")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.pollFirst());
                } else {
                    System.out.println(-1);
                }
            } else if (cmd.equals("pop_back")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.pollLast());
                } else {
                    System.out.println(-1);
                }
            } else if (cmd.equals("size")) {
                System.out.println(deque.size());
            } else if (cmd.equals("empty")) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (cmd.equals("front")){
                if (!deque.isEmpty()) {
                    System.out.println(deque.peekFirst());
                }else{
                    System.out.println(-1);
                }
            } else if (cmd.equals("back")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.peekLast());
                }else{
                    System.out.println(-1);
                }
            }


        }


    }
}
