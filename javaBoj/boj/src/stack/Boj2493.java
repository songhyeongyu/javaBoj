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
        searchTop();
        printResult();
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

    private void searchTop() {

        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty() && arr[i] > stack.peek().high) {
                    stack.pop();
                }
            if (stack.isEmpty()) {
                ans[i] = 0;
            }else{
                ans[i] = stack.peek().index + 1;
            }

            stack.push(new Top(arr[i], i));
        }
    }

    private void printResult() {
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }
    }


    static class Top{
        int high;
        int index;

        public Top(int high, int index) {
            this.high = high;
            this.index = index;
        }
    }




}
