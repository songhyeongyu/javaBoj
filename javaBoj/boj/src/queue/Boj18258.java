package queue;

import java.util.*;
import java.io.*;

public class Boj18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int back = 0;
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int element = Integer.parseInt(st.nextToken());
                back = element;
                queue.add(element);
            } else if (cmd.equals("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.remove()).append("\n");
                } else {
                    sb.append("-1\n");
                }
            } else if (cmd.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (cmd.equals("empty")) {
                sb.append(queue.isEmpty() ? "1\n" : "0\n");
            } else if (cmd.equals("front")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.peek()).append("\n");
                } else {
                    sb.append("-1\n");
                }
            } else if (cmd.equals("back")) {
                if (!queue.isEmpty()) {
                    sb.append(back).append("\n");
                } else {
                    sb.append("-1\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
