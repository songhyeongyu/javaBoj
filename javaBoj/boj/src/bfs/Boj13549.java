package bfs;

import java.util.*;
import java.io.*;


public class Boj13549 {

    static int N;
    static int K;
    static int[] arr;
    static boolean[] visit;

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

        arr = new int[K+1];
        visit = new boolean[K+1];

        Arrays.fill(arr, -1);
        arr[N] = 0;
        visit[N] = true;
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(N);

        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();

            int[] d = {2 * cur, cur + 1, cur - 1};

            for (int i = 0; i < 3; i++) {
                int nx = d[i];

                if(nx < 0 || nx > K ){
                    continue;
                }

                if (!visit[nx]) {
                    if(i == 0) {
                        arr[nx] = Math.min(arr[cur],arr[nx]);
                        deque.offerFirst(nx);
                    }else {
                        arr[nx] = arr[cur] + 1;
                        deque.offerLast(nx);
                    }
                    visit[nx] = true;
                }
            }
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(arr[K]);

    }

    private static void swap() {
        if (N > K) {
            int temp = N;
            N = K;
            K = temp;
        }
    }

}
