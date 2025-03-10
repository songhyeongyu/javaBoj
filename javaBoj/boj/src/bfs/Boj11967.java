package bfs;

import java.io.*;
import java.util.*;

public class Boj11967 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int M;
    static int count;

    static int[][] board;
    static boolean[][] visited;
    static boolean[][] light;
    static Queue<Pair> queue = new LinkedList<>();
    static List<Node> tmp = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        Boj11967 process = new Boj11967();
        process.run();

    }

    private void run() throws IOException {
        init();
        turnOn();
        System.out.println(count);
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        visited = new boolean[N][N];
        light = new boolean[N][N];

        board[0][0] = 0;
        visited[0][0] = true;
        light[0][0] = true;

        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], 1);
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int firstX = Integer.parseInt(st.nextToken()) - 1;
            int firstY = Integer.parseInt(st.nextToken()) - 1;

            int secondX = Integer.parseInt(st.nextToken()) - 1;
            int secondY = Integer.parseInt(st.nextToken()) - 1;

            tmp.add(new Node(firstX, firstY, secondX, secondY));
        }

        Collections.sort(tmp, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.x1 == o2.x1) {
                    return o1.y1 - o2.y1;
                }
                return o1.x1 - o2.x1;
            }
        });
    }

    private void turnOn() {
        queue.offer(new Pair(0, 0));
        for (int i = 0; i < tmp.size(); i++) {
            int nxtX = tmp.get(i).x2;
            int nxtY = tmp.get(i).y2;
            light[nxtX][nxtY] = true;
            boolean flag = true;
            while (flag) {
                Pair cur = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }

                    if (visited[nx][ny] && light[nx][ny] && flag ) {
                        queue.offer(new Pair(nx, ny));
                        continue;
                    }


                    if (nx == nxtX && ny == nxtY && light[nx][ny] && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        count++;
                        queue.offer(new Pair(nx, ny));
                        flag = false;
                    }

                }
            }


        }

    }

    static class Node{
        int x1;
        int y1;
        int x2;
        int y2;


        public Node(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
