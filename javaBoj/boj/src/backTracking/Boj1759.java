package backTracking;

import java.util.*;
import java.io.*;


public class Boj1759 {

    static int L;
    static int C;

    static char[] password;
    static char[] arr;
    static boolean[] used;
    static List<Character> mo;


    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Boj1759 process = new Boj1759();
        process.run();
    }


    private void run() throws IOException {
        init();
        func(0, 0);
        System.out.println(sb.toString());
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        mo = new ArrayList<>(5);
        mo.add('a');
        mo.add('e');
        mo.add('i');
        mo.add('o');
        mo.add('u');
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        password = new char[C];
        arr = new char[C];
        used = new boolean[C];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < C; i++) {
            password[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(password);
    }

    private void func(int cur, int st) {
        if (cur == L) {
            List<Character> lst = new ArrayList<>();
            int mCnt = 0;
            int jCnt = 0;
            for (int i = 0; i < L; i++) {
                lst.add(arr[i]);
            }
            if (lst.size() < 3) {
                return;
            }

            for (Character c : lst) {
                if (mo.contains(c)) {
                    mCnt++;
                }else {
                    jCnt++;
                }
            }
            if (mCnt < 1 || jCnt < 2) {
                return;
            }
            for (Character c : lst) {
                sb.append(c);
            }
            sb.append("\n");
            return;
        }

        char tmp = ' ';

        for (int i = st; i < C; i++) {
            if (tmp != password[i] && !used[i]) {
                arr[cur] = password[i];
                tmp = arr[cur];
                used[i] = true;
                func(cur + 1, i);
                used[i] = false;
            }
        }
    }

}
