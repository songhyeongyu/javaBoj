package sort;

import java.io.*;
import java.util.*;

public class Boj2910 {
    static HashMap<Integer,Node> sets = new LinkedHashMap<>();
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        Boj2910 process = new Boj2910();
        process.run();
    }

    private void run() throws IOException {
        init();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!sets.containsKey(num)) {
                sets.put(num, new Node(i, 1));
            }else{
                sets.put(num, new Node(sets.get(num).index, sets.get(num).count + 1));
            }
        }


        ArrayList<Map.Entry<Integer, Node>> lst = new ArrayList<>(sets.entrySet());

        Collections.sort(lst, new Comparator<Map.Entry<Integer, Node>>() {
            @Override
            public int compare(Map.Entry<Integer, Node> o1, Map.Entry<Integer, Node> o2) {
                if (o1.getValue().count == o2.getValue().count) {
                    return o1.getValue().index - o2.getValue().index;
                }
                return o2.getValue().count - o1.getValue().count;
            }
        });

        for (Map.Entry<Integer, Node> integerNodeEntry : lst) {
            int count = 0;
            while(count < integerNodeEntry.getValue().count) {
                System.out.print(integerNodeEntry.getKey()+ " ");
                count++;
            }
        }
    }

    static class Node{
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }


}
