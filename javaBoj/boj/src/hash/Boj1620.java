package hash;

import java.util.*;
import java.io.*;

public class Boj1620 {
    static Map<String, Integer> pocketMonByName = new HashMap<>();
    static Map<Integer, String> pocketMonByNumber = new HashMap<>();
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        Boj1620 process = new Boj1620();

        process.run();
    }

    private void run() throws IOException{
        init();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            pocketMonByName.put(input, i + 1);
            pocketMonByNumber.put(i+1, input);
        }

        for (int i = 0; i < M; i++) {
            String input = bf.readLine();
            if(input.matches("\\d+")){
                int number = Integer.parseInt(input);
                System.out.println(pocketMonByNumber.get(number));
            }
            else{
                System.out.println(pocketMonByName.get(input));
            }
        }
    }
}
