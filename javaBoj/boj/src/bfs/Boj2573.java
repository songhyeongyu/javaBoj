package bfs;

import java.util.*;
import java.io.*;

public class Boj2573 {
    static int N;
    static int M;
    static int after;

    static int[][] ice;
    static boolean[][][] isIce;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Deque<Node> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Boj2573 process = new Boj2573();
        process.run();
    }

    private void run() throws IOException {
        init();
        System.out.println(searchMelting());
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ice = new int[N][M];
        isIce = new boolean[N][M][1000001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > 0) {
                    dq.offer(new Node(i, j));
                }
                ice[i][j] = num;
            }
        }
    }

    private int searchMelting() {
        int now = 0;
        int cnt = 0;

        while (!dq.isEmpty()) {
            boolean isZero = false;
            for (Node node : dq) {

            }
            now++;

            Iterator<Node> iterator = dq.iterator();
            while (iterator.hasNext()) {
                Node node = iterator.next();
                if (ice[node.x][node.y] == 0) {
                    isZero = true;
                    isIce[node.x][node.y][now] = true;
                    iterator.remove();
                }
            }

            if (isZero) {
                int count = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (ice[i][j] != 0 && !isIce[i][j][now]) {
                            bfs(i,j,now);
                            count++;
                        }
                    }
                    if (count > 1) {
                        return now;
                    }
                }
            }


        }
        return 0;

    }


    private void bfs(int x,int y, int now) {
        Deque<Node> deque = new LinkedList<>();
        deque.add(new Node(x, y));
        isIce[x][y][now] = true;

        while (!deque.isEmpty()) {
            Node cur = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >=M) {
                    continue;
                }

                if (ice[nx][ny] == 0) {
                    continue;
                }

                if (isIce[nx][ny][now]) {
                    continue;
                }

                isIce[nx][ny][now] = true;
                deque.offer(new Node(nx, ny));


            }
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


