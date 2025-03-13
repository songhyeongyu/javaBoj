package simulation;

import java.util.*;
import java.io.*;


public class Boj15683 {
    static int row;
    static int col;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Boj15683 process = new Boj15683();
        process.run();
    }

    public void run() throws IOException {
        init();
        System.out.println(answer);


    }


    public void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int[][] board = new int[row][col];
        List<Node> cctv = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            StringTokenizer input = new StringTokenizer(bf.readLine());
            for (int j = 0; j < col; j++) {
                int number = Integer.parseInt(input.nextToken());
                if (number != 0 && number != 6) {
                    cctv.add(new Node(i, j, number, number + i + j));
                }
                board[i][j] = number;
            }
        }
        recur(cctv,0,board);

    }

    private void recur(List<Node> cctv, int index, int[][] map) {
        if (index >= cctv.size()) {
            int count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] == 0) {
                        count++;
                    }
                }
            }
            answer = Math.min(answer, count);
            return;
        }
        Node cur = cctv.get(index);

        for (int i = 0; i < 4; i++) {
            checkCctv(i,cur.r,cur.c,cur.cctvNum, cur.cctvDifNum, map);
            recur(cctv, index + 1, map);
            checkCctv(i,cur.r,cur.c,cur.cctvNum, cur.cctvDifNum, map);
        }
    }

    private void checkCctv(int dir, int r, int c, int cctvNum, int cctvDif, int[][] map) {
        if (cctvNum == 1) {
            check(r, c, map, dir, cctvDif);
        } else if (cctvNum == 2) {
            // 2번 CCTV: 서로 반대 방향 (0-2, 1-3)
            check(r, c, map, dir, cctvDif);
            check(r, c, map, (dir + 2) % 4, cctvDif);
        } else if (cctvNum == 3) {
            // 3번 CCTV: 직각 방향
            check(r, c, map, dir, cctvDif);
            check(r, c, map, (dir + 1) % 4, cctvDif);
        } else if (cctvNum == 4) {
            // 4번 CCTV: 3방향 감시
            check(r, c, map, dir, cctvDif);
            check(r, c, map, (dir + 1) % 4, cctvDif);
            check(r, c, map, (dir + 2) % 4, cctvDif);
        } else if (cctvNum == 5) {
            // 5번 CCTV: 모든 방향 감시
            for (int i = 0; i < 4; i++) {
                check(r, c, map, i, cctvDif);
            }
        }
    }





    private void check(int r, int c, int[][] map, int dir, int cctvDif) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (map[r][c] != 6) {
            r = dx[dir] + r;
            c = dy[dir] + c;

            if (r < 0 || r >= row || c < 0 || c >= col) {
                break;
            }else {
                if (map[r][c] == 0) {
                    map[r][c] = cctvDif;
                } else if (map[r][c] == cctvDif) {
                    map[r][c] = 0;
                }
            }
        }
    }



    static class Node {
        int r;
        int c;
        int cctvNum;
        int cctvDifNum;

        public Node(int r, int c, int cctvNum, int cctvDifNum) {
            this.r = r;
            this.c = c;
            this.cctvNum = cctvNum;
            this.cctvDifNum = cctvDifNum;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", cctvNum=" + cctvNum +
                    ", cctvDifNum=" + cctvDifNum +
                    '}';
        }
    }
}
