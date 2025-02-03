package bfs;

import java.util.*;
import java.io.*;


public class Boj1697 {
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Deque<Pair> deque = new LinkedList<>();

        int[] area = new int[20];

        Arrays.fill(area, -1);

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        deque.offerFirst(new Pair(N, 0));
        area[N] = 0;




        while (!deque.isEmpty()) {
            Pair cur = deque.pollFirst();
//            if (cur.x > K) {
//                break;
//            }
            int[] nextPositions = {cur.x - 1, cur.x + 1, 2 * cur.x};
            for(int next : nextPositions){
                if(next < 0 || next > K){
                    continue;
                }
                if (area[next] >= 0) {
                    continue;
                }
                area[next] = cur.y + 1;
                deque.offerLast(new Pair(next, cur.y + 1));
            }
        }
//        System.out.println(Arrays.toString(area));
        System.out.println(area[K]);
    }


    static class Pair{
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
