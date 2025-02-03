package bfs;

import java.util.*;
import java.io.*;


public class Boj5014 {
    public static void main(String[] args) throws IOException{
        Deque<Integer> deque = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] startLink = new int[F];
        Arrays.fill(startLink,-1);
        deque.offer(S-1);
        System.out.println(Arrays.toString(startLink));
        startLink[S-1] = 0;
        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();

            int[] moving = {cur + U, cur - D};

            for (int i = 0; i < 2; i++) {
                int n = moving[i];
                if (n < 0 || n >= F) {
                    continue;
                }
                if (startLink[n] >= 0) {
                    continue;
                }
                startLink[n] = startLink[cur] + 1;
                deque.offer(n);
            }
        }

        if (startLink[G - 1] == -1) {
            System.out.println("use the stairs");
        }
        else {
            System.out.println(startLink[G-1]);
        }









    }
}
