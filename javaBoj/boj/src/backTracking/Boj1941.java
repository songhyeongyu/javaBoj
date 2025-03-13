package backTracking;

import java.util.*;
import java.io.*;

public class Boj1941 {
    static int[][] students;
    static boolean[] visited;
    private static final int WOMEN = 5;
    private static final int LIM = 3;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int princesses;

    public static void main(String[] args) throws IOException {
        Boj1941 process = new Boj1941();
        process.run();
    }

    private void run() throws IOException {
        init();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        students = new int[WOMEN][WOMEN];
        visited = new boolean[WOMEN * WOMEN];
        for (int i = 0; i < WOMEN; i++) {
            String input = bf.readLine();
            for (int j = 0; j < WOMEN; j++) {
                char group = input.charAt(j);
                students[i][j] = group;
            }
        }

    }

    private void func(int idx,int depth,int yCnt) {
        if (yCnt >= LIM) {
            return;
        }

        if (depth == 7) {
            if (bfs(idx / 5, idx % 5)) {
                princesses++;
            }
        }

        for (int i = 0; i < 25; i++) {
            visited[i] = true;
            if (students[i / 5][i % 5] == 'Y') {
                func(i,depth+1,yCnt+1);
            }
            else {
                func(i, depth + 1, yCnt);
            }
            visited[i] = false;
        }

    }

    private boolean bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] bfsVisit = new boolean[WOMEN][WOMEN];

        queue.offer(new Node(x, y));
        bfsVisit[x][y] = true;
        int yCnt = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();


            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= WOMEN || ny < 0 || ny >= WOMEN) {
                    continue;
                }

            }
        }
        return true;
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

