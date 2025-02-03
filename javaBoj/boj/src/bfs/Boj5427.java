package bfs;

import java.util.*;
import java.io.*;

public class Boj5427 {
    static int col;
    static int row;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] miro;
    static int[][] timeS;
    static int[][] timeF;
    static Deque<Pair> dequeF = new LinkedList<>();
    static Deque<Pair> dequeS = new LinkedList<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int escapeX;
    static int escapeY;

    public static void main(String[] args) throws IOException{
        Boj5427 process = new Boj5427();
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            process.init(bf);
            process.bfsFire();
            if (process.bfsSang()) {
                System.out.println(timeS[escapeX][escapeY] + 1);
            }
            else{
                System.out.println("IMPOSSIBLE");
            }

        }


    }

    public void init(BufferedReader bf) throws IOException{
        String input = bf.readLine();
        StringTokenizer st = new StringTokenizer(input);
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        miro = new char[col][row];
        timeF = new int[col][row];
        timeS = new int[col][row];

        for (int i = 0; i < col; i++) {
            Arrays.fill(timeF[i], -1);
            Arrays.fill(timeS[i], -1);
        }

        for (int i = 0; i < col; i++) {
            String map = bf.readLine();
            for (int j = 0; j < row; j++) {
                char m = map.charAt(j);
                if (m == '@') {
                    dequeS.offer(new Pair(i, j));
                    timeS[i][j] = 0;
                }
                if (m == '*') {
                    dequeF.offer(new Pair(i, j));
                    timeF[i][j] = 0;
                }
                miro[i][j] = m;
            }
        }

    }

    public void bfsFire() {
        while (!dequeF.isEmpty()) {
            Pair cur = dequeF.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= col || ny < 0 || ny >= row) {
                    continue;
                }

                if (miro[nx][ny] != '.') {
                    continue;
                }

                if (timeF[nx][ny] >= 0) {
                    continue;
                }

                timeF[nx][ny] = timeF[cur.x][cur.y] + 1;
                dequeF.offer(new Pair(nx, ny));
            }
        }
    }

    public boolean bfsSang() {
        while (!dequeS.isEmpty()) {
            Pair cur = dequeS.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= col || ny < 0 || ny >= row) {
                    escapeX = cur.x;
                    escapeY = cur.y;
                    dequeS.clear();
                    dequeF.clear();
                    return true;
                }

                if (miro[nx][ny] != '.') {
                    continue;
                }

                if (timeS[nx][ny] >= 0) {
                    continue;
                }

                if (timeF[nx][ny] != -1 && timeF[nx][ny] <= timeS[cur.x][cur.y] + 1) {
                    continue;
                }

                timeS[nx][ny] = timeS[cur.x][cur.y] + 1;
                dequeS.offer(new Pair(nx, ny));

            }

        }
        return false;
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
