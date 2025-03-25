package simulation;

import java.io.*;
import java.util.*;

public class Boj15686 {
    static int N;
    static int M;
    static int[][] board;
    static List<Node> house;
    static int[] temp;
    static int[] arr;
    static List<Node> chicken;
    static List<Integer>[] dist;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        Boj15686 process = new Boj15686();
        process.run();
    }

    private void run() throws IOException {
        init();
        calculateDist();
        recur(0,0);
        System.out.println(result);


    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    house.add(new Node(i, j));
                }
                else if (num == 2) {
                    chicken.add(new Node(i, j));
                }
                board[i][j] = num;
            }
        }
        dist = new ArrayList[house.size()];
        for (int i = 0; i < house.size(); i++) {
            dist[i] = new ArrayList<>();
        }
        temp = new int[chicken.size()];
        visited = new boolean[chicken.size()];
        arr = new int[M];


        //거리를 모두 계산 해놓고
    }

    private void calculateDist() {
        //1. 집을 기준으로
        int index = 0;
        for (Node h : house) {
            for (Node c : chicken) {
                dist[index].add(Math.abs(h.x - c.x) + Math.abs(h.y - c.y));
            }
            if (index >= house.size()) {
                break;
            }
            index++;
        }
    }

    private void recur(int cur,int start) {
        if (cur == M) {
            for (int i = 0; i < M; i++) {
                arr[i] = temp[i];
            }
            int ans = 0;
            for (List<Integer> d : dist) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < arr.length; i++) {
                    min = Math.min(min, d.get(arr[i]));
                }
                ans += min;
            }
            result = Math.min(ans, result);
            return;

        }

        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[cur] = i;
                recur(cur + 1,i + 1);
                visited[i] = false;
            }
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
