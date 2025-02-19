package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Boj1920 {
    static int N;
    static int[] arr;
    static int M;
    static int[] targetArr;


    public static void main(String[] args) throws IOException {
        Boj1920 process = new Boj1920();
        process.run();
    }

    private void run() throws IOException{

        init();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);
        M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        targetArr = new int[M];
        for (int i = 0; i < M; i++) {
            targetArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int result = binarySearch(targetArr[i]);
            System.out.println(result);
        }



    }

    private int binarySearch(int target) {
        int st = 0;
        int ed = N - 1;

        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (target < arr[mid]) {
                ed = mid - 1;
            }else if(target > arr[mid]  ){
                st = mid + 1;
            }
            else{
                return 1;
            }
        }
        return 0;
    }
}
