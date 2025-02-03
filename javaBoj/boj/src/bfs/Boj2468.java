package bfs;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Boj2468 {
    static int N;
    static int[][] land;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxHeight;

    static Deque<Pair> deque = new LinkedList<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    // deque도 새로, visit도 새로 받아야 되고
    public static void main(String[] args) throws IOException{
        Boj2468 process = new Boj2468();
        process.init(bf);

    }

    public void init(BufferedReader bf) throws IOException{
        N = Integer.parseInt(bf.readLine());
        maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(height, maxHeight);
                land[i][j] = height;
            }
        }
    }

    public void bfs(int x, int y) {

        int count = 0;
        deque.offer(new Pair(x,y));


        


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
