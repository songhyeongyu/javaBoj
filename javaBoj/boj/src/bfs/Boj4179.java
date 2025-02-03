package bfs;

import java.util.*;
import java.io.*;

public class Boj4179 {
    static int[][] timeJ;
    static int[][] timeF;
    static int col;     // size, count, sex
    static int row;
    static char[][] miro;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Deque<Pair> dequeJ = new LinkedList<>();
        Deque<Pair> dequeF = new LinkedList<>();

        for (int i = 0; i < col; i++) {
            Arrays.fill(timeJ[i], -1);
            Arrays.fill(timeF[i], -1);
        }


        for (int i = 0; i < col; i++) {
            String input = bf.readLine();
            for (int j = 0; j < row; j++) {
                miro[i][j] = input.charAt(j);
                if (miro[i][j] == 'J') {
                    dequeJ.offer(new Pair(i, j));
                    timeJ[i][j] = 0;
                }
                if (miro[i][j] == 'F') {
                    dequeF.offer(new Pair(i, j));
                    timeF[i][j] = 0;
                }
            }
        }

        while (!dequeF.isEmpty()) {
            Pair cur = dequeF.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= col || ny < 0 || ny >= row) {
                    continue;
                }

                if (timeF[nx][ny] >= 0) {
                    continue;
                }

                if (miro[nx][ny] != '.') {
                    continue;
                }
                timeF[nx][ny] = timeF[cur.x][cur.y] + 1;
                dequeF.offer(new Pair(nx, ny));

            }
        }

        while (!dequeJ.isEmpty()) {
            Pair cur = dequeJ.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= col || ny < 0 || ny >= row) {
                        System.out.println(timeJ[cur.x][cur.y] + 1);
                        System.exit(0);
                }
                if(timeF[nx][ny] != -1 &&(timeF[nx][ny] <= timeJ[cur.x][cur.y] + 1)){
                    continue;
                }

                if (miro[nx][ny] != '.') {
                    continue;
                }

                if (timeJ[nx][ny] >= 0) { // 이미 방문한곳
                    continue;
                }
                timeJ[nx][ny] = timeJ[cur.x][cur.y] + 1;
                dequeJ.offer(new Pair(nx, ny));

            }
        }

    }

    private static void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        miro = new char[col][row];
        timeJ = new int[col][row];
        timeF = new int[col][row];
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
