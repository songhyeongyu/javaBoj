package bfs;

import java.util.*;
import java.io.*;

public class Boj13549 {
    static int N;
    static int M;

    static int[] board;

    public static void main(String[] args) throws IOException{
        Boj13549 process = new Boj13549();
        process.run();
    }

    private void run() throws IOException{
        init();
        bfs();
//        System.out.println(Arrays.toString(board));
        System.out.println(board[M]);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
//        if (N > M) {
//            int temp = N;
//            N = M;
//            M = temp;
//        }

        board = new int[Math.max(N, M) * 2 + 2];

        Arrays.fill(board,-1);
    }

    private void bfs() {
        Deque<Integer> dq = new LinkedList<>();
        dq.offer(N);
        board[N] = 0;


        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            if (cur == M) {
                break;
            }
            if (cur * 2 < board.length && board[cur * 2] == -1) {
                board[cur * 2] = board[cur];
                dq.offerFirst(cur * 2);
            }

            int[] dx = {cur - 1, cur + 1};
            for (int i = 0; i < 2; i++) {
                int nx = dx[i];
                if (nx < 0 || nx >= board.length) {
                    continue;
                }
                if (board[nx] == -1) {
                    board[nx] = board[cur] + 1;
                    dq.offer(nx);
                }
            }
        }
    }
}
