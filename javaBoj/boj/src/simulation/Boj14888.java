package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj14888 {
    static int N;
    static int[] arr;
    static boolean[] isUsed;
    static int[] temp;
    static int[] op;
    static char[] operator;
    static char[] result;
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Boj14888 process = new Boj14888();
        process.run();
    }

    private void run() throws IOException {
        init();
        recur(0);
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arr = new int[N];


        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        int size = Arrays.stream(op).sum();
        operator = new char[size];
        isUsed = new boolean[size];
        temp = new int[size];
        result = new char[size];
        int index = 0;
        for (int i = 0; i < op.length; i++) {
            int cnt = op[i] + index;
            while (index != cnt) {
                if (i == 0) {
                    operator[index] = '+';
                } else if (i == 1) {
                    operator[index] = '-';
                } else if (i == 2) {
                    operator[index] = '*';
                } else {
                    operator[index] = '/';
                }
                index++;
            }
        }

    }


    private void recur(int cur) {
        if (cur == operator.length) {
            for (int i = 0; i < operator.length; i++) {
                result[i] = operator[temp[i]];
            }
            int val = arr[0];

            for (int i = 0; i < result.length; i++) {
                if (result[i] == '+') {
                    val += arr[i + 1];
                } else if (result[i] == '-') {
                    val -= arr[i + 1];
                } else if (result[i] == '*') {
                    val *= arr[i + 1];
                } else if (result[i] == '/') {
                    val /= arr[i + 1];
                }
            }
            maxValue = Math.max(val, maxValue);
            minValue = Math.min(val, minValue);
            return;
        }
        for (int i = 0; i < operator.length; i++) {
            if (!isUsed[i]) {
                temp[cur] = i;
                isUsed[i] = true;
                recur(cur + 1);
                isUsed[i] = false;
            }
        }
    }

}
