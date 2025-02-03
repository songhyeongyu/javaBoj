package stack;

import java.util.*;
import java.io.*;

public class Boj2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Pair> tower = new Stack<>();
        tower.push(new Pair(100000001, 0)); // Initial value to handle edge cases

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (tower.peek().height < height) {
                tower.pop();
            }
            sb.append(tower.peek().index).append(" ");
            tower.push(new Pair(height, i));
        }

        System.out.println(sb);
    }

    // Helper class to store height and index as a pair
    static class Pair {
        int height, index;

        public Pair(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}
