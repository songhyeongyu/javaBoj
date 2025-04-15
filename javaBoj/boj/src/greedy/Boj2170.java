package greedy;

import java.io.*;
import java.util.*;

public class Boj2170 {
    static int N;
    static List<Node> point = new ArrayList<>();



    public static void main(String[] args) throws IOException{
        Boj2170 process = new Boj2170();
        process.run();
    }
    public void run() throws IOException {
        init();
        makeLine();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            point.add(new Node(s, e));
        }

        Collections.sort(point, (Node o1, Node o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });
    }

    private void makeLine() {

        int st = point.get(0).x;
        int ed = point.get(0).y;
        int total = ed - st;


        for (int i = 1; i < point.size(); i++) {
            if (point.get(i).x <= ed && point.get(i).x >= st && point.get(i).y > ed) {
                total += point.get(i).y - ed;
                ed = point.get(i).y;
            } else if (ed == point.get(i).y || ed > point.get(i).y) {
                continue;
            } else{
                total += point.get(i).y - point.get(i).x;
                st = point.get(i).x;
                ed = point.get(i).y;
            }
        }

        System.out.println(total);

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
