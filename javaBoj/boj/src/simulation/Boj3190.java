package simulation;

import java.io.*;
import java.util.*;

public class Boj3190 {

    static int N;
    static int[][] board;
    static int K;
    static int L;
    static List<Node> timeDir;
    static int time;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Deque<Pair> snake = new LinkedList<>();


    public static void main(String[] args) throws IOException{
        Boj3190 process = new Boj3190();
        process.run();
    }

    private void run() throws IOException {
        init();
        moveSnake();
        System.out.println(time);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        board = new int[N][N];
        K = Integer.parseInt(bf.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r - 1][c - 1] = 2;
        }
        L = Integer.parseInt(bf.readLine());
        timeDir = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            timeDir.add(new Node(time, dir));
        }
        for (Node node : timeDir) {
            System.out.println(node.time + " " + node.dir);
        }
    }

    private void moveSnake() {
        int direction = 1;
        int index = 0;
        snake.offer(new Pair(0, 0));
        board[0][0] = 1;
        while (true) {


            if (index < timeDir.size()) {
                int changeTime = timeDir.get(index).time;
                if (changeTime == time) {
                    char changeDir = timeDir.get(index).dir;
                    if (changeDir == 'D') {
                        direction = (direction + 3) % 4;
                    } else if (changeDir == 'L') {
                        direction = (direction + 1) % 4;
                    }
                    index++;
                }
            }


            time++;
            Pair cur = snake.peekFirst();


            int nx = cur.x + dx[direction];
            int ny = cur.y + dy[direction];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                break;
            }

            if (board[nx][ny] == 1) {
                break;
            }

            if (board[nx][ny] == 2) {
                snake.offerFirst(new Pair(nx, ny));
            } else if (board[nx][ny] == 0) {
                Pair tail = snake.pollLast();
                board[tail.x][tail.y] = 0;
                snake.offerFirst(new Pair(nx, ny));
            }
            board[nx][ny] = 1;


        }
    }


    static class Node {
        int time;
        char dir;

        public Node(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
