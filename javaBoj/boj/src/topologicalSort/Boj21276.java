package topologicalSort;

import java.util.*;
import java.io.*;

public class Boj21276 {
    static int N;
    static int M;

    static int[] indegree;

    static List<List<Integer>> graph;
    static Map<String, Integer> map = new HashMap<>();
    static List<String> result;
    static Map<String, List<String>> geResult = new HashMap<>();

    public static void main(String[] args) throws IOException{
        Boj21276 process = new Boj21276();
        process.run();
    }

    private void run() throws IOException {
        init();
        sort();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        result = new ArrayList<>();
        N = Integer.parseInt(bf.readLine());
        indegree = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            map.put(st.nextToken(), i + 1);
        }

        M = Integer.parseInt(bf.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();
            int childIndex = map.get(child);
            int parentIndex = map.get(parent);

            graph.get(parentIndex).add(childIndex);
            indegree[childIndex]++;

            // 여기에서 진짜 부모-자식 관계 넣기 (직계만)
            if (!geResult.containsKey(parent)) {
                geResult.put(parent, new ArrayList<>());
            }
            geResult.get(parent).add(child);
        }

        // 자식이 없는 사람도 geResult에 빈 리스트로 넣기 (필요하면)
        for (String name : map.keySet()) {
            geResult.putIfAbsent(name, new ArrayList<>());
        }
    }

    private void sort() {
        Queue<Integer> que = new LinkedList<>();
        int generationCount = 0;
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
                generationCount++;
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int nxt : graph.get(cur)) {
                indegree[nxt]--;
                if (indegree[nxt] == 0) {
                    que.offer(nxt);
                }
            }
        }

        // 출력 정렬 (옵션)
        List<String> sortedKeys = new ArrayList<>(geResult.keySet());
        Collections.sort(sortedKeys);

        for (String parent : sortedKeys) {
            List<String> children = geResult.get(parent);
            Collections.sort(children);
            System.out.println(parent + " " + children);
        }
    }

    private String getNameByValue(int value) {
        for (Map.Entry<String, Integer> se : map.entrySet()) {
            if (se.getValue() == value) {
                return se.getKey();
            }
        }
        return null;
    }
}
