package queue;

import java.util.*;
import java.io.*;

public class Boj2164 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> que = new LinkedList<>();

        int N = Integer.parseInt(bf.readLine());

        for (int i = 1; i < N+1; i++) {
            que.add(i);
        }

        while (que.size() != 1) {
            que.poll();
            que.offer(que.poll());
        }

        System.out.println(que.peek());



        }


    }


