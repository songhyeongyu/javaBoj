package dualqueue;

import java.util.*;
import java.io.*;


public class Boj7662 {

    static int N;
    static int M;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Boj7662 process = new Boj7662();
        N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            process.run();
        }
    }

    private void run() throws IOException{
        init();
    }

    private void init() throws IOException {
        M = Integer.parseInt(bf.readLine());

        // D -1 -> 최솟값 삭제 or I n은 n 삽입 D 1은 최대값 삭제 -> 비어있는데 d이면 무시
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            int key = 0;

            if (cmd.equals("I")) {
                treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
            }
            else if (cmd.equals("D")) {

                if (treeMap.isEmpty()) {
                    continue;
                }
                if (num == 1) {
                    key = treeMap.lastKey();
                } else if (num == -1) {
                    key = treeMap.firstKey();
                }

                int count = treeMap.get(key);
                if (count == 1) {
                    treeMap.remove(key);
                }else{
                    treeMap.put(key, count - 1);
                }


            }
        }

        if (treeMap.isEmpty()) {
            System.out.println("EMPTY");
        }else{
            System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
        }


    }
}
