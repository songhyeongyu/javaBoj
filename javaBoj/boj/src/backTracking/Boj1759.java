package backTracking;

import java.util.*;
import java.io.*;


public class Boj1759 {

    static int L;
    static int C;

    static char[] password;
    static char[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Boj1759 process = new Boj1759();
        process.run();
    }

    private void run() throws IOException {
        init();
        func(0,0);
        System.out.println(sb.toString());
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        password = new char[C];
        arr = new char[C];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < C; i++) {
            password[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(password);
    }

    private void func(int count,int cur) {
        if (count == L) {
            for (int i = 0; i < L; i++) {
                sb.append(arr[i]);
            }
            sb.append("\n");
            return;
        }

        for (int i = cur; i < C; i++) {
            arr[count] = password[i];
            func(count+1,i+1);
        }

    }

}
