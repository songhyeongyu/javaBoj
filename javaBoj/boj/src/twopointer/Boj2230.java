package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*3 3
        1
        5
        3*/
public class Boj2230 {

    static int N;
    static int M;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        Boj2230 process = new Boj2230();
        process.run();

    }

    private void run() throws IOException{
        init();
        search();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
    }

    private void search() {
        int mn = Integer.MAX_VALUE;
        int ed = 0;
        for (int st = 0; st < N; st++) {
            while (ed < N && arr[ed] - arr[st] < M) {
                ed++;
            }
            if (ed == N) {
                break;
            }
            mn = Math.min(mn, arr[ed] - arr[st]);

        }
        System.out.println(mn);
    }



}
