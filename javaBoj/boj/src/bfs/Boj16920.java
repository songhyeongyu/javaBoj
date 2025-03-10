package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16920 {
    static int N;
    static int M;
    static int P;

    static int[] move;
    static char[][] board;
    static boolean[][] visit;


    static Deque<Node> deque = new LinkedList<>();
    static HashMap<Character, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Boj16920 process = new Boj16920();

        process.run();
    }

    private void run() throws IOException{
        init();
        bfs();
        countNum();
        for (Map.Entry<Character, Integer> characterIntegerEntry : hashMap.entrySet()) {
            System.out.print(characterIntegerEntry.getValue() + " ");
        }
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        move = new int[P + 1];
        board = new char[N][M];
        visit = new boolean[N][M];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i < P+1; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                board[i][j] = c;
                if (Character.isDigit(c)) {
                    int n = c - '0';
                    deque.offer(new Node(i, j, n));
                    visit[i][j] = true;
                }
            }
        }
        List<Node> tmp = new ArrayList<>(deque);
        Collections.sort(tmp, Comparator.comparingInt(n -> n.num));
        deque.clear();
        deque.addAll(tmp);

    }

    public void bfs() {
        while (!deque.isEmpty()) {
            Node cur = deque.pollFirst();
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                for (int step = 1; step <= move[cur.num]; step++) {
                    int nx = cur.x + dx[i] * step;
                    int ny = cur.y + dy[i] * step;
                    makeBoard(nx, ny, cur);
                }
            }
        }
    }

    private void countNum() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char c = board[i][j];
                if (Character.isDigit(c)) {
                    hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
                }
            }
        }
    }

    private static void makeBoard(int nx,int ny,Node cur) {
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
            return;
        }

        if (visit[nx][ny] || board[nx][ny] != '.') {
            return;
        }

        board[nx][ny] = (char) ('0' + cur.num);
        visit[nx][ny] = true;
        deque.offerLast(new Node(nx, ny, cur.num));
    }


    static class Node{
        int x;
        int y;
        int num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

    }
    //한턴이 끝나고 다시 정렬
}
