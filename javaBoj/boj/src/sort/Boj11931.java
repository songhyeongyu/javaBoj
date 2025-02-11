package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11931 {
    static int N;
    static int[] arr;
    static int[] tmp;
    public static void main(String[] args) throws IOException {
        Boj11931 process = new Boj11931();
        process.run();
    }
    public void run() throws IOException {
        init();
        mergeSort(0, N);
        printResult();

    }

    public void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            arr[i] = num;
        }

    }

    public void merge(int st, int ed) {
        int mid = (st + ed) / 2;

        int rdx = st;
        int ldx = mid;

        for (int i = st; i < ed; i++) {
            if (rdx == mid) {
                tmp[i] = arr[ldx++];
            } else if (ldx == ed) {
                tmp[i] = arr[rdx++];
            } else if (arr[ldx] <= arr[rdx]) {
                tmp[i] = arr[rdx++];
            }else{
                tmp[i] = arr[ldx++];
            }
        }

        for (int i = st; i < ed; i++) {
            arr[i] = tmp[i];
        }

    }

    public void mergeSort(int st, int ed) {
        if (st == ed - 1) {
            return;
        }
        int mid = (st + ed) / 2;
        mergeSort(st, mid);
        mergeSort(mid, ed);
        merge(st, ed);
    }

    public void printResult() {
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
