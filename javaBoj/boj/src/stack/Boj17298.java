package stack;

import java.util.*;
import java.io.*;

public class Boj17298 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> oge = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int element = Integer.parseInt(st.nextToken());
            while (!oge.isEmpty() && (oge.peek() < element)) {
                oge.pop();
                sb.append(element).append(" ");
            }
            oge.push(element);
        }
//        sb.append("-1");
        sb.insert(0, "-1");


    }
}
