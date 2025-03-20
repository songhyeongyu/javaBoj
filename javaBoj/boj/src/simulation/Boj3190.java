package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj3190 {

    static int N;
    static int K;
    static int L;
    static int[][] board;
    static Queue<Direction> direQue = new LinkedList<>();
    static Deque<Node> dq = new LinkedList<>();
    static int second;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        Boj3190 process = new Boj3190();
        process.run();
    }

    private void run() throws IOException {
        init();
        moveSnake();
        System.out.println(second);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        K = Integer.parseInt(bf.readLine());
        board = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = 2;
        }

        L = Integer.parseInt(bf.readLine());

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            direQue.add(new Direction(x, dir));
        }
        System.out.println("first");
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();



    }

    private void moveSnake() {
    }


    static class Direction {
        int time;
        char dir;

        public Direction(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
