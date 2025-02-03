package stack;

import java.util.*;
import java.io.*;

public class Boj10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                int element = Integer.parseInt(st.nextToken());
                stack.push(element);
            } else if (cmd.equals("pop")) {
                if(stack.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(stack.pop());
                }
            }
            else if(cmd.equals("size")){
                System.out.println(stack.size());
            } else if (cmd.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println("1");
                }else {
                    System.out.println("0");
                }
            } else if (cmd.equals("top")) {
                if(stack.isEmpty()){
                    System.out.println("-1");
                    continue;
                }
                System.out.println(stack.peek());
            }
        }


    }
}
