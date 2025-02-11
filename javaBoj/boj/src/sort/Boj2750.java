package sort;

import java.util.*;
import java.io.*;

public class Boj2750 {
    static int[] arr;
    static int[] tmp;
    static int N;
    public static void main(String[] args) throws IOException{
        Boj2750 process = new Boj2750();
        process.run();

    }
    public void run() throws IOException {
        init();
    /*    mergeSort(0, arr.length);*/
        printResult();
    }

    public void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
    }

    /*public void merge(int st, int ed) {
        int mid = (st + ed) / 2;
        int ldx = st;
        int rdx = mid;

        for (int i = st; i < ed; i++) {
            if (rdx == ed) {
                tmp[i] = arr[ldx++];
            } else if (ldx == mid) {
                tmp[i] = arr[rdx++];
            } else if (arr[ldx] <= arr[rdx]) {
                tmp[i] = arr[ldx++];
            }else{
                tmp[i] = arr[rdx++];
            }
        }
        for (int i = st; i < ed; i++) {
            arr[i] = tmp[i];
        }
    }

    private void mergeSort(int st, int ed) {
        if (st >= ed - 1) {
            return;
        }
        int mid = (st + ed) / 2;
        mergeSort(st, mid);
        mergeSort(mid, ed);
        merge(st, ed);
    }
*/
    public void printResult() {
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }



}
