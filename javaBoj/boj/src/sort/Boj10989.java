package sort;

import java.io.*;

public class Boj10989 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Boj10989 process = new Boj10989();
        process.run();
    }

    private void run() throws IOException {
        init();
        countSort();
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[10001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }
    }

    private void countSort() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 10000; i++) {
            while (arr[i] > 0) {
                bw.write(i + "\n");
                arr[i]--;
            }
        }
        bw.flush();
        bw.close();
    }
}
