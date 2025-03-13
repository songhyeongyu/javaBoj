package simulation;

import java.io.*;
import java.util.*;

public class Boj15686 {
    static int N;
    static int M;

    static int[][] board;

    static List<Node> chicken = new LinkedList<>();
    static List<Node> house = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        Boj15686 process = new Boj15686();
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
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {

                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    house.add(new Node(i+1, j+1));
                }
                else if (num == 2) {
                    chicken.add(new Node(i+1,j+1));
                }
                board[i][j] = num;
            }

        }

        int[][] dist = calculateDist();
        HashMap<Integer, Integer> before = findMinChicken(dist);
        HashMap<Integer, Integer> after = sortHashMap(before);
        List<Integer> keys = new ArrayList<>(after.keySet());
        for (Integer key : keys) {
            System.out.println(key);
        }
        int[][] select = new int[M][dist[0].length];

        for (Map.Entry<Integer, Integer> integerIntegerEntry : after.entrySet()) {
            System.out.println(integerIntegerEntry.getKey() + " " + integerIntegerEntry.getValue());
        }
        int cnt = 0;
        while (cnt < M) {  // M개 만큼 뽑기
            int index = (keys.size() - 1) - cnt; // 뒤에서부터 선택
            select[cnt] = dist[keys.get(index)]; // 선택한 값 저장
            cnt++;
        }



        System.out.println(Arrays.deepToString(select));
        int ans = findDistance(select);
        System.out.println(ans);

    }

    private int[][] calculateDist() {
        int[][] distance = new int[chicken.size()][house.size()];
        for (int i = 0; i < chicken.size(); i++) {
            for (int j = 0; j < house.size(); j++) {
                distance[i][j] = Math.abs(chicken.get(i).x - house.get(j).x) + Math.abs(chicken.get(i).y - house.get(j).y);
            }
        }

        return distance;
    }

    private HashMap<Integer,Integer> findMinChicken(int[][] dist) {
        HashMap<Integer,Integer> minStores = new LinkedHashMap<>();
        for (int i = 0; i < dist.length; i++) {
            minStores.put(i, 0);
        }
        for (int i = 0; i < dist[0].length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < dist.length; j++) {
                if (dist[j][i] < min) {
                    min = dist[j][i];
                    minIndex = j;
                }
            }

            if (minIndex != -1) {
                if (minStores.containsKey(minIndex)) {
                    minStores.put(minIndex,minStores.get(minIndex) + 1);
                }
            }
        }
        return minStores;
    }

    private HashMap<Integer, Integer> sortHashMap(HashMap<Integer, Integer> minStores) {

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(minStores.entrySet());

        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        HashMap<Integer, Integer> sortMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> e : entryList) {
            sortMap.put(e.getKey(), e.getValue());
        }

        return sortMap;
    }

    private int findDistance(int[][] dist) {
        int sumValue = 0;
        for (int i = 0; i < dist[0].length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < dist.length; j++) {
                if (dist[j][i] < min) {
                    min = dist[j][i];
                    minIndex = j;
                }
            }

            if (minIndex != -1) {
                sumValue += min;
            }
        }

        return sumValue;
    }




    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
