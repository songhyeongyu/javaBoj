package bfs;

import java.util.*;
import java.io.*;

public class Boj2178 {
    static int col;
    static int row;
    static int[][] miro;
    static int[][] distance;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        miro = new int[col][row];
        distance = new int[col][row];
        for (int i = 0; i < col; i++) {
            Arrays.fill(distance[i], -1);
        }
        for (int i = 0; i < col; i++) {
            String input = bf.readLine();
            for (int j = 0; j < row; j++) {
                miro[i][j] = input.charAt(j) - '0';
            }
        }
        bfs(0, 0);
//        System.out.println(Arrays.deepToString(distance));
        System.out.println(distance[col-1][row-1] + 1);

    }

    private static void bfs(int x, int y) {
        Deque<Pair> deque = new LinkedList<>();
        deque.offer(new Pair(x,y));
        distance[x][y] = 0;
        int count = 0;

        while(!deque.isEmpty()){
            Pair cur = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= col || ny < 0 || ny >= row){
                    continue;
                }
                if (distance[nx][ny] >= 0) {
                    continue;
                }

                if (miro[nx][ny] == 0) {
                    continue;
                }
                deque.offer(new Pair(nx, ny));
                distance[nx][ny] = distance[cur.x][cur.y] + 1;
            }
        }

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
