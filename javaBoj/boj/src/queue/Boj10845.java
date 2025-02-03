package queue;

import java.util.*;
import java.io.*;

public class Boj10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int back = 0;
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int element = Integer.parseInt(st.nextToken());
                back = element;
                queue.add(element);
            } else if (cmd.equals("pop")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.remove());
                    continue;
                }
                System.out.println(-1);
            } else if (cmd.equals("size")) {
                System.out.println(queue.size());
            } else if (cmd.equals("empty")){
                if (queue.isEmpty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            } else if (cmd.equals("front")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.peek());
                }
                else{
                    System.out.println(-1);
                }
            } else if (cmd.equals("back")) {
                if (!queue.isEmpty()) {
                    System.out.println(back);
                }else{
                    System.out.println(-1);
                }
            }


        }
    }
}
