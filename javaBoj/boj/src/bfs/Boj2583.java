package bfs;


import java.util.*;
import java.io.*;

public class Boj2583 {
    static int col;
    static int row;
    static int squareCount;
    static boolean[][] mono;
    static Deque<Pair> deque = new LinkedList<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int startX ;
    static int startY;
    static int endX ;
    static int endY ;

    public static void main(String[] args) throws IOException{
        Boj2583 process = new Boj2583();
        process.init(bf);
        process.makeSquare();
        process.squareSize();

    }

    public void init(BufferedReader bf) throws IOException{
        StringTokenizer sizeInput = new StringTokenizer(bf.readLine());
        row = Integer.parseInt(sizeInput.nextToken());
        col = Integer.parseInt(sizeInput.nextToken());
        squareCount = Integer.parseInt(sizeInput.nextToken());

        mono = new boolean[col][row];
    }

    public void makeSquare() throws IOException{
        for (int i = 0; i < squareCount; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());
            changeTrueFalse();
        }
    }

    private static void changeTrueFalse() {
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (mono[i][j]) {
                    continue;
                }
                mono[i][j] = true;
            }
        }
    }

    public void squareSize() {
        int bfsCount = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> result= new ArrayList<>();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (!mono[i][j]) {
                    int a = bfs(i, j);
                    result.add(a+1);
                    bfsCount++;
                }
            }
        }

        Collections.sort(result);
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(bfsCount);
        System.out.print(sb);

    }



    private static int bfs(int x, int y) {
        int count = 0;
        deque.clear();
        deque.offer(new Pair(x, y));
        mono[x][y] = true;

        while (!deque.isEmpty()) {
            Pair cur = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];


                if (nx < 0 || nx >= col || ny < 0 || ny >= row) {
                    continue;
                }

                if (mono[nx][ny]) {
                    continue;
                }

                mono[nx][ny] = true;
                deque.offer(new Pair(nx, ny));
                count++;
            }
        }

        return count;
    }


    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

}
