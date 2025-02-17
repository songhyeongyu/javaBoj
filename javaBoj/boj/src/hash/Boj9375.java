package hash;

import java.util.*;
import java.io.*;


public class Boj9375 {

    static int T;
    static int N;
    static Map<String, Integer> cloth = new HashMap<>();

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        Boj9375 process = new Boj9375();
        T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            process.run();
        }
    }

    private void run() throws IOException{
        init();
        searchValue();
        cloth.clear();
    }

    private void init() throws IOException{
        N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            String type = st.nextToken();
            if (cloth.containsKey(type)) {
                cloth.put(type, cloth.get(type) + 1);
                continue;
            }
            cloth.put(type, 1);
        }
    }

    private void searchValue() {
        int ans = 1;
        for (Map.Entry<String,Integer> me: cloth.entrySet()) {
            int num = me.getValue();
            ans *= (num+1);
        }

        System.out.println(ans-1);
    }
}
