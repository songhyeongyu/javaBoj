package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj1644 {

    static int N;
    static int[] number;
    static List<Integer> lst = new ArrayList<>();
    static int cnt;

    public static void main(String[] args) throws IOException {
        Boj1644 process = new Boj1644();
        process.run();

    }

    private void run() throws IOException {
        init();
        searchSum();


    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        boolean[] flag = searchPrime(N);
        int count = 0;

        for (boolean b : flag) {
            if (b) {
                count++;
            }
        }
        number = new int[count];
        int index = 0;
        for (int i = 0; i < N + 1; i++) {
            if (flag[i]) {
                number[index++] = i;
            }
        }
        if (flag[N]) {
            cnt++;
        }

        if (N == 1) {
            System.out.println(0);
            System.exit(0);
        }


    }

    private boolean[] searchPrime(int n) {
        boolean[] prime = new boolean[n + 1];

        // 0과 1은 소수가 아니므로 false

        Arrays.fill(prime, true);
        if (n > 0) prime[0] = false;
        if (n > 1) prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) { // 소수라면
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false; // i의 배수는 소수가 아님
                }
            }
        }
        if (n > 0) prime[0] = false;
        if (n > 1) prime[1] = false;
        return prime;
    }

    private void searchSum() {
        int ed = 0;
        int tot = number[0];
        int mn = Integer.MAX_VALUE;


        for (int st = 0; st < number.length; st++) {
            while (ed < number.length && tot < N) {
                ed++;
                if (ed != N) {
                    tot += number[ed];

                }
            }
            if (ed == number.length - 1) {
                break;
            }
            if(tot == N){
                cnt++;
            }
            tot -= number[st];
        }


        System.out.println(cnt);
    }

}
