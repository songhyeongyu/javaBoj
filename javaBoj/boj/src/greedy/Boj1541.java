package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1541 {

    static int num;
    public static void main(String[] args) throws IOException {
        Boj1541 process = new Boj1541();

        process.run();
    }

    private void run() throws IOException{
        init();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        parseInput(input);
    }

    private void parseInput(String input) {
        StringTokenizer st = new StringTokenizer(input, "+-", true);
        Deque<Pair> prefix = new LinkedList<>();
        int ans = 0;
        int cnt = st.countTokens();
        String last = "";
        int flag = 1;
        for (int i = 0; i < cnt; i++) {
            String a = st.nextToken();
            if (a.chars().allMatch(Character::isDigit)) {
                num += Integer.parseInt(a) * flag;
            } else {
                if (a.equals("-")) {
                    flag = -1;
                }
            }
        }
        System.out.println(num);

    }

    static class Pair {
        String prefix;
        int num;

        public Pair(String prefix, int num) {
            this.prefix = prefix;
            this.num = num;
        }
    }

}
