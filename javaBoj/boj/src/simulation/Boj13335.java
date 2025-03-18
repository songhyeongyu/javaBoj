package simulation;

import java.util.*;
import java.io.*;


public class Boj13335 {
    static int n;
    static int w;
    static int L;

    static int[] board;
    static Queue<Integer> que = new LinkedList<>();

    static int second;

    public static void main(String[] args) throws IOException{
        Boj13335 process = new Boj13335();
        process.run();
    }

    private void run() throws IOException {
        init();
        goBridge();
        System.out.println(second);

    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        board = new int[w];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            que.offer(Integer.parseInt(st.nextToken()));
        }
    }

    private void goBridge() {
        int index = 0;
        boolean flag = false;
        while (!que.isEmpty()) {
            int sumVal = Arrays.stream(board).sum();
            if (sumVal + que.peek() > L) {
                for (int i = w - 1; i > 0; i--) {
                    board[i] = board[i - 1];
                }
                board[0] = 0;
                second++;
                int innerVal = Arrays.stream(board).sum();
                if (innerVal + que.peek() > L) {
                    continue;
                } else{
                    flag = true;
                    index = 0;
                }
            }

            else if(sumVal > 0 && L >= sumVal + que.peek()){
                for (int i = w - 1; i > 0; i--) {
                    board[i] = board[i - 1];
                }
                board[0] = 0;
                index = 0;
            }
            int cur = que.poll();
            board[index%w] = cur;
            index++;
            if (flag) {
                flag = false;
                continue;
            }
            second++;
        }

        second += board.length;
    }
}
