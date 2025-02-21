package bfs;

import java.util.*;
import java.io.*;


public class Boj13549 {

    static int N;
    static int K;
    static int[] arr;
    static boolean[] visit;
    static Deque<Integer> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        new Boj13549().run();
    }

    private void run() throws IOException{
        init();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        swap();
        arr = new int[K + 2];
        visit = new boolean[K + 2];
        bfs();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(visit));


    }

    private void bfs() {
        dq.offer(N);
        visit[N] = true;
        while (!dq.isEmpty()) {
            Integer cur = dq.pollFirst();

            if (cur > 0 && cur < K + 1) {
                int now = 2 * cur;
                if (!(now < 0 || now > K + 1 || visit[now])) {
                    arr[2 * cur] = 0;
                    dq.offerFirst(2 * cur);
                    visit[2 * cur] = true;
                }


                int[] dir = {cur - 1, cur + 1};

                for (int i = 0; i < 2; i++) {
                    int now1 = dir[i];
                    if (now1 < 0 || now1 >= K) {
                        continue;
                    }
                    arr[now1] = arr[cur] + 1;
                    visit[now1] = true;
                    dq.offerLast(now1);
                }
            }
        }

    }
    private static void swap() {
        if (N > K) {
            int temp = N;
            N = K;
            K = temp;
        }
    }

}
