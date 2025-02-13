package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Boj2217 {
    static int N;
    static Integer[] rope;

    public static void main(String[] args) throws IOException {
        Boj2217 process = new Boj2217();
        process.run();
    }

    private void run() throws IOException{
        init();
        countWeight();

    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        rope = new Integer[N];
        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(rope, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
    }

    private void countWeight() {
        int maxValue = rope[0];

        for (int i = 0; i < N; i++) {
            maxValue = Math.max(maxValue, rope[i] * (i + 1));
        }

        System.out.println(maxValue);
    }
}
