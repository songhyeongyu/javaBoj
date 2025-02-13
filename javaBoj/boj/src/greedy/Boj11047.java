package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj11047 {
    static List<Integer> money = new ArrayList<>();
    static int N;
    static int price;
    public static void main(String[] args) throws IOException {

        Boj11047 process = new Boj11047();
        process.run();
    }

    private void run() throws IOException{
        init();
        countMoney();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        price = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            money.add(Integer.parseInt(bf.readLine()));
        }

        money.sort(Comparator.reverseOrder());

    }

    private void countMoney() {
        int count = 0;
        int i = 0;
        while (true) {
            if (price >= money.get(i)) {
                price -= money.get(i);
                count++;
                continue;
            }
            if (price <= 0) {
                break;
            }
            i++;
        }
        System.out.println(count);
    }
}
