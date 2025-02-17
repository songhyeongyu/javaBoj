package hash;

import java.util.*;
import java.io.*;


public class Boj7785 {
    static int N;
    static Map<String, String> comeOut = new TreeMap<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException{
        Boj7785 process = new Boj7785();
        process.run();
    }

    private void run() throws IOException{
        init();
        printResult();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            String situation = st.nextToken();

            if (situation.equals("enter")) {
                comeOut.put(name, situation);
            }else{
                comeOut.remove(name);
            }
        }
    }

    private void printResult() {

        for (String string : comeOut.keySet()) {
            System.out.println(string);
        }

    }
}
