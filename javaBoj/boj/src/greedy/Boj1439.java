package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1439 {
    static char[] arr0;
    static char[] arr1;
    static int N;

    public static void main(String[] args) throws IOException {
        Boj1439 process = new Boj1439();
        process.run();
    }

    private void run() throws IOException{
        init();
        int ans = Math.min(makeOne(), makeZero());
        System.out.println(ans);
    }

    private void init() throws IOException{
        //모두를 뒤집어 본다
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        N = input.length();
        arr0 = new char[N];
        arr1 = new char[N];

        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            arr0[i] = c;
            arr1[i] = c;
        }
    }

    private int makeZero() {
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < N; i++) {
            if(arr0[i] != '0') {
                j = i;
                while (arr0[j] != '0') {
                    arr0[j] = '0';
                    j++;
                    if (j >= N) {
                        break;
                    }
                }
                cnt += 1;
                i = j;
            }
        }
        return cnt;
    }

    private int makeOne() {
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < N; i++) {
            if(arr1[i] != '1') {
                j = i;
                while (arr1[j] != '1') {
                    arr1[j] = '1';
                    j++;
                    if (j >= N) {
                        break;
                    }
                }
                cnt += 1;
                i = j;
            }
        }
        return cnt;
    }

}
