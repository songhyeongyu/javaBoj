package simulation;

import java.io.*;
import java.util.*;

public class Boj3190 {

    static int N;
    static int K;
    static int L;
    static int second;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] board;
    static List<Direction> directions = new ArrayList<>();
    static Deque<Dummy> dummies = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Boj3190 process = new Boj3190();
        process.run();
    }

    private void run() throws IOException {
        init();
        makeDummy();
        System.out.println(second);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        K = Integer.parseInt(bf.readLine());
        board = new int[N][N];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x - 1][y - 1] = 2;//사과
        }
        L = Integer.parseInt(bf.readLine());

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            directions.add(new Direction(x, d));
        }
    }

    private void makeDummy() {
        dummies.offer(new Dummy(0, 0));
        int index = 0;
        int dir = 0;
        while (true) {
            second++;
            Dummy cur = dummies.peekFirst();
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];


            if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 1) {
                break;
            }

            if (board[nx][ny] == 0) {
                Dummy tail = dummies.pollLast();
                board[tail.x][tail.y] = 0;
            }
            dummies.offerFirst(new Dummy(nx, ny));
            board[nx][ny] = 1;


            if (index < directions.size() && directions.get(index).time == second) {
                if (directions.get(index).dir == 'L') {
                    dir = (dir + 3) % 4;
                } else if (directions.get(index).dir == 'D') {
                    dir = (dir + 1) % 4;
                }
                index++;
            }

        }


    }

    static class Direction {
        int time;
        char dir;

        public Direction(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static class Dummy {
        int x;
        int y;

        public Dummy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
