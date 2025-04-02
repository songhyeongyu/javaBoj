package simulation;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;
public class Boj16985 {

    static int[][][] maze;
    static int[][][] dist;
    static int[][][] temp;

    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {0, 0, 1, 0, -1, 0};
    static int[] dz = {-1, 0, 0, 0, 0, 1};


    public static void main(String[] args) throws IOException {
        Boj16985 process = new Boj16985();
        process.run();
    }

    private void run() throws IOException {
        init();
        int[][][] tempArr = new int[5][5][5];
        boolean[] used = new boolean[5];
        recur(0,used,tempArr,0);
        recur(0,used,tempArr,1);
        recur(0,used,tempArr,2);
        recur(0,used,tempArr,3);
        recur(0,used,tempArr,4);
    }

    private void init() throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        maze = new int[5][5][5];
        dist = new int[5][5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < 5; k++) {
                    maze[i][j][k] = Integer.parseInt(st.nextToken());
                    dist[i][j][k] = -1;
                }
            }
        }
    }

    private void recur(int cur, boolean[] isUsed,int[][][] tempArr,int firstIdxType) {
        }





    static class Node{
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    //보류
}
