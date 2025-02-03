package stack;

import java.util.*;
import java.io.*;


public class Boj10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                stack.pop();
                continue;
            }
            stack.push(n);
        }
        int ans = 0;

        for (Integer i : stack) {
            ans += i;
        }

        System.out.println(ans);
    }
}
