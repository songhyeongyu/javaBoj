package bfs;

import java.util.*;
import java.io.*;


public class Boj7576 {


    static int[][] tomato;
    static int col;
    static int row;
    static int[][] day;
    static Deque<Pair> deque;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        boolean flag = false;
        deque = new LinkedList<>();
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        tomato = new int[col][row];
        day = new int[col][row];

        for (int i = 0; i < col; i++) {
            Arrays.fill(day[i], -1);
        }

        for (int i = 0; i < col; i++) {
            StringTokenizer s = new StringTokenizer(bf.readLine());
            for (int j = 0; j < row; j++) {
                tomato[i][j] = Integer.parseInt(s.nextToken());
                if (tomato[i][j] == 1) {
                    deque.offer(new Pair(i, j));
                    day[i][j] = 0;
                }
                if (tomato[i][j] == -1) {
                    day[i][j] = -2;
                }
            }
        }
        bfs(deque);
        int maxValue = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                maxValue = Math.max(maxValue, day[i][j]);
                if (day[i][j] == -1) {
                    flag = true;
                    break;
                }
            }
        }


        if (flag) {
            System.out.println(-1);
        }
        else{
            System.out.println(maxValue);
        }


    }

    public static void bfs(Deque<Pair> q) {

        while (!q.isEmpty()) {
            Pair cur = q.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= col || ny < 0 || ny >= row) {
                    continue;
                }

                if (tomato[nx][ny] == -1) {
                    continue;
                }

                if (day[nx][ny] >= 0) {
                    continue;
                }
                day[nx][ny] = day[cur.x][cur.y] + 1;
                deque.offer(new Pair(nx, ny));
            }

        }

    }


    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
