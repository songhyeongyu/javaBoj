package deque;

import java.util.*;
import java.io.*;


public class Boj5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            String cmd = bf.readLine();
            int flag = 0;
            int M = Integer.parseInt(bf.readLine());
            String input = bf.readLine();
            input = input.replace("[", "").replace("]", "");
            String[] numList = input.split(",");
            Deque<Integer> deque = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            int rCount = 0;
            int dCount = 0;

            for (int j = 0; j < M; j++) {
                deque.offer(Integer.parseInt(numList[j]));
            }
            if (!cmd.contains("D") && M == 0) {
                System.out.println("[]");
                continue;
            }

            for (char c : cmd.toCharArray()) {
                if (c == 'R') {
                    rCount++;
                } else if (c == 'D') {
                    if (rCount % 2 == 0) {
                        if (deque.isEmpty()) {
                            flag = 2;
                            break;
                        }
                        deque.pollFirst();
                    } else {
                        if (deque.isEmpty()) {
                            flag = 2;
                            break;
                        }
                        deque.pollLast();
                    }
                }
            }


            if (flag == 2) {
                System.out.println("error");
            } else {
                if (rCount % 2 == 0) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                        if (!deque.isEmpty()) {
                            sb.append(",");
                        }

                    }
                    System.out.println("[" + sb + "]");

                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                        if (!deque.isEmpty()) {
                            sb.append(",");
                        }
                    }
                    System.out.println("[" + sb + "]");
                }
            }

        }
    }

}
