package stack;

import java.util.*;
import java.io.*;

public class Boj6198 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        Stack<Pair> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(bf.readLine());
            while (!stack.isEmpty() && stack.peek().height < height) {
                stack.pop();

            }

            stack.push(new Pair(height,count));
        }
    }

    static class Pair{
        int height;
        int count;

        Pair(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

}
