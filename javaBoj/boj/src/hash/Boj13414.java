package hash;

import java.util.*;
import java.io.*;

public class Boj13414 {
    static Map<String, Integer> su = new TreeMap<>();
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        Boj13414 process = new Boj13414();
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

        for (int i = 0; i < M; i++) {
            String input = bf.readLine();
            if(su.containsKey(input)){
                su.replace(input, i + 1);
                continue;
            }
            su.put(input, i + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(su.entrySet());
        entryList.sort(Comparator.comparingInt(Map.Entry::getValue));
        int i = 1;
        for (Map.Entry<String , Integer> integerIntegerEntry : entryList) {
            if (i > N) {
                break;
            }
            System.out.println(integerIntegerEntry.getKey());
            i++;
        }

    }
}
