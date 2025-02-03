package array;

import java.util.*;
import java.io.*;

public class Boj11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            HashMap<Character,Integer> originMap = new HashMap<>();
            HashMap<Character,Integer> copyMap = new HashMap<>();
            String origin = st.nextToken();
            String copy = st.nextToken();
            getCounter(origin, originMap);
            getCounter(copy, copyMap);

            if (originMap.equals(copyMap)) {
                System.out.println("Possible");
            }else{
                System.out.println("Impossible");
            }


        }
    }

    private static void getCounter(String input, HashMap<Character, Integer> map) {
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

    }
}
