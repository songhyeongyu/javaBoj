package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14502 {
    static int M;
    static int N;
    static int[][] board;
    static int ZeroCnt;
    static int maxValue = Integer.MIN_VALUE;
    static List<Node> temp;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        Boj14502 process = new Boj14502();
        process.run();
    }

    private void run() throws IOException {
        init();
        System.out.println(maxValue);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        Queue<Node> virus = new LinkedList<>();
        temp = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    ZeroCnt++;
                }
                else if (num == 2) {
                    virus.offer(new Node(i,j));
                }
                board[i][j] = num;
            }
        }

        recur(0,0,virus);
    }

    private void recur(int cur,int start,Queue<Node> virus) {
        if (cur == 3) {
            for (Node node : temp) {
                board[node.x][node.y] = 1;
            }

            int count = bfs(virus);

            int ans = ZeroCnt - count -3;

            maxValue = Math.max(ans, maxValue);


            for (Node node : temp) {
                board[node.x][node.y] = 0;
            }


            return;
        }


        for (int i = start; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    temp.add(new Node(i, j));
                    recur(cur + 1,i+1,virus);
                    temp.remove(temp.size() - 1);
                }

            }
        }
    }

    private int bfs(Queue<Node> virus) {
        int count = 0;
        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        for (Node node : virus) {
            q.offer(new Node(node.x, node.y));
            visited[node.x][node.y] = true;
        }
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (visited[nx][ny] || board[nx][ny] != 0) {
                    continue;
                }

                q.offer(new Node(nx, ny));
                visited[nx][ny] = true;
                count++;
            }

        }
        return count;
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
