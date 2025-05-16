package programmers.algo.lv2;

import java.util.*;

public class 귤_고르기 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int t : tangerine) {
            if (!map.containsKey(t)) {
                map.put(t, 1);
            } else {
                map.put(t, map.get(t) + 1);
            }
        }

        List<Node> nodes = new ArrayList<>();

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            nodes.add(new Node(m.getKey(), m.getValue()));
        }

        Collections.sort(nodes, (n1, n2) -> {
            return n2.y - n1.y;
        });

        for (Node n : nodes) {
            if (k <= 0) {
                break;
            }
            k -= n.y;
            answer++;
        }

        return answer;
    }

    static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

}
