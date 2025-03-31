package simulation;

import java.util.*;
import java.io.*;

public class Boj15685 {
    static int N;
    static Set<Node> point;
    static List<Integer> direction;
    static List<Node> lst;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        Boj15685 process = new Boj15685();
        process.run();
    }

    private void run() throws IOException {
        init();

    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //  방향을 고정한 상태에서 똑같은 방향 + 움직임
        N = Integer.parseInt(bf.readLine());
        point = new HashSet<>();
        direction = new ArrayList<>();
        lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            point.add(new Node(x, y));
            lst.add(new Node(x, y));
            makePoint(x, y, d, g);



        }
    }

    private void makePoint(int x, int y, int d, int g) {
        point.add(new Node(x+dx[d], y+dy[d]));
        lst.add(new Node(x+dx[d], y+dy[d]));

        for (int i = 1; i <= g; i++) {
            d = (d + 1) % 4;

            for (int j = 0; j < i; j++) {

                int r = lst.getLast().x;
                int c = lst.getLast().y;

                point.add(new Node(r + dx[(d+j)%4], c + dy[(d+j)%4]));
                lst.add(new Node(r + dx[(d+j)%4], c + dy[(d+j)%4]));
            }

            for (Node node : lst) {
                System.out.println(node.x + " " + node.y);
            }
            System.out.println("-".repeat(20));


        }
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
