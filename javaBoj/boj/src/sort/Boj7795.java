package sort;

import java.io.*;
import java.util.*;


public class Boj7795 {
    static int[] A;
    static int[] B;
    static int aCount;
    static int bCount;
    static int T;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        Boj7795 process = new Boj7795();
        T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            process.run();
        }
    }

    public void run() throws IOException {
        init();
        System.out.println(compareAB());
    }

    public void init() throws IOException {

        StringTokenizer st = new StringTokenizer(bf.readLine());

        aCount = Integer.parseInt(st.nextToken());
        bCount = Integer.parseInt(st.nextToken());
        A = new int[aCount];
        B = new int[bCount];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < aCount; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < bCount; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);
    }

    public int compareAB() {
        int count = 0;
        for (int i = 0; i < aCount; i++) {
            for (int j = 0; j < bCount; j++) {
                if (A[i] > B[j]) {
                    count++;
                }else {
                    break;
                }
            }
        }

        return count;
    }
}
