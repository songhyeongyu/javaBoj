package bfs;

import java.util.*;
import java.io.*;
public class Boj7562 {
    static int N;
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[][] board;

    static Deque<Pair> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Boj7562 process = new Boj7562();
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            process.init(bf);
            process.bfs();
            System.out.println(board[endX][endY]);
        }

    }

    public void init(BufferedReader bf) throws IOException{
        String input = bf.readLine();
        N = Integer.parseInt(input);
        board = new int[N][N];

        String startIdx = bf.readLine();
        StringTokenizer s = new StringTokenizer(startIdx);
        startX = Integer.parseInt(s.nextToken());
        startY = Integer.parseInt(s.nextToken());

        String endIdx = bf.readLine();
        StringTokenizer e = new StringTokenizer(endIdx);
        endX = Integer.parseInt(e.nextToken());
        endY = Integer.parseInt(e.nextToken());
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], -1);
        }
        deque.offer(new Pair(startX, startY));
        board[startX][startY] = 0;
    }

    public void bfs() {
        while (!deque.isEmpty()) {
            Pair cur = deque.pollFirst();

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (board[nx][ny] >= 0) {
                    continue;
                }

                board[nx][ny] = board[cur.x][cur.y] + 1;
                deque.offer(new Pair(nx, ny));
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
