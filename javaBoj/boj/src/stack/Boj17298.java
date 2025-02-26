package stack;

import java.util.*;
import java.io.*;

public class Boj17298 {

    static int N;
    static int[] arr;
    static int[] ans;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        Boj17298 process = new Boj17298();
        process.run();
    }

    private void run() throws IOException {
        init();
        searchStack();
        printResult();
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        ans = new int[N];
        Arrays.fill(ans, -1);
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void searchStack() {

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
    }

    private void printResult() {
        for (int an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb.toString());
    }




}
