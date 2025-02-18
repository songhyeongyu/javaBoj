package bfs;

import java.util.*;
import java.io.*;

public class Boj9466 {
    static int[] students;
    static int[] state;
    static int N;

    private static final int NOT_VISITED = 0;
    private static final int VISITED = 1;
    private static final int CYCLE_IN = 2;
    private static final int NOT_CYCLE_IN = 3;

    public static void main(String[] args) throws IOException{
        Boj9466 process = new Boj9466();
        process.run();
    }

    private void run() throws IOException{
        init();
        for (int i = 1; i <= N; i++) {
            if(state[i] == NOT_VISITED) {
                bfs(i);
            }
        }
        System.out.println(Arrays.toString(state));

    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        state = new int[N + 1];
        students = new int[N + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void bfs(int x) {
        int cur = x;
        while (true) {
            state[cur] = VISITED;
            cur = students[cur];
            if (state[cur] == CYCLE_IN || state[cur] == NOT_CYCLE_IN) {
                cur = x;
                while (state[cur] == VISITED) {
                    state[cur] = CYCLE_IN;
                    cur = students[cur];
                }
                return;
            }


            if (state[cur] == VISITED && cur != x) {
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = students[cur];
                }
                return;
            }

            if (state[cur] == VISITED && cur == x) {
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = students[cur];
                }
                return;
            }
        }
    }


}
