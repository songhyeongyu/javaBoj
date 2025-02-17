package stack;

import java.util.*;
import java.io.*;

public class Boj2493 {
    static int N;
    static Stack<Top> stack = new Stack<>();
    static int[] arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        Boj2493 process = new Boj2493();
        process.run();

    }

    private void run() throws IOException{
        init();
        searchStack();

    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        ans = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    int k = 0;
    private void searchStack() {
        for (int i = 0; i <N; i++) {
            while (!stack.isEmpty() && stack.peek().height < arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                ans[i] = stack.peek().idx;
            }else {
                ans[i] = 0;
            }
            stack.push(new Top(arr[i], i));
        }
    }
    static class Top{
        int height;
        int idx;

        public Top(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

}
