package stack;

import java.util.*;
import java.io.*;

public class Boj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            list[i] = num;
        }
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int j = 0;
        boolean flag = false;

        while (true) {
            if (flag || j == N) {
                break;
            }
            if (!st.isEmpty() && st.peek() == list[j]) {
                st.pop();
                j++;
                sb.append('-');
                continue;
            }
            st.push(i);
            i++;
            sb.append('+');

            if(i > N + 1){
                flag = true;
            }

        }
        if(!flag) {
            for (char c : sb.toString().toCharArray()) {
                System.out.println(c);
            }
        }
        else {
            System.out.println("NO");
        }


    }
}

