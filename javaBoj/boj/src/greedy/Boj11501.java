package greedy;

import java.io.*;
import java.util.*;

public class Boj11501 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Integer[] stock;
    public static void main(String[] args) throws IOException {
        Boj11501 process = new Boj11501();
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            process.run();
        }
    }

    private void run() throws IOException{
        init();
        countStock();
    }

    private void init() throws IOException{
        N = Integer.parseInt(bf.readLine());
        stock = new Integer[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            stock[i] = Integer.parseInt(st.nextToken());
        }
    }



    private void countStock() {
        int cnt = 0;
        long money = 0;
        int maXvalue = stock[stock.length -1];
        for (int i = N-2; i > -1; i--) {
            if (maXvalue > stock[i]) {
                money -= stock[i];
                cnt += 1;
            }else{
                if (cnt > 0) {
                    money += cnt * maXvalue;
                }
                cnt = 0;
                maXvalue = stock[i];
            }
        }
        if (cnt > 0) {
            money += maXvalue * cnt;
        }
        System.out.println(money);

    }


}
