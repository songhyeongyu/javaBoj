package programmers.algo.lv2;

import java.util.*;

public class 짝지어_제거하기 {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }

}
