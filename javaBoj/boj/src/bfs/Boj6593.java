package bfs;

import java.util.*;

public class Boj6593 {
    static int height;
    static int col;
    static int row;
    static int escapeX;
    static int escapeY;
    static int escapeZ;

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static char[][][] building;
    static int[][][] time;

    static Deque<Pair> deque = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Boj6593 process = new Boj6593();
        while (true) {
            process.init(scanner);
            process.bfs();
            deque.clear();
            int escapeTime = time[escapeZ][escapeX][escapeY];
            if (escapeTime == -1) {
                System.out.println("Trapped!");
                continue;
            }
            System.out.println("Escaped in " + escapeTime + " minute(s).");
        }
    }

    public void init(Scanner scanner) {
        height = scanner.nextInt();
        row = scanner.nextInt();
        col = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거

        if (height == 0 && row == 0 && col == 0) {
            System.exit(0);
        }

        building = new char[height][row][col];
        time = new int[height][row][col];
        fillTimeMinusOne();

        for (int k = 0; k < height; k++) {
            if (k > 0) scanner.nextLine(); // 층 사이 빈 줄 제거
            for (int i = 0; i < row; i++) {
                String input = scanner.nextLine();
                for (int j = 0; j < col; j++) {
                    char c = input.charAt(j);
                    if (c == 'E') {
                        escapeZ = k;
                        escapeX = i;
                        escapeY = j;
                    } else if (c == 'S') {
                        deque.offer(new Pair(k, i, j));
                        time[k][i][j] = 0;
                    }
                    building[k][i][j] = c;
                }
            }
        }
    }

    private static void fillTimeMinusOne() {
        for (int k = 0; k < height; k++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    time[k][i][j] = -1;
                }
            }
        }
    }

    public void bfs() {
        while (!deque.isEmpty()) {
            Pair cur = deque.pollFirst();

            for (int i = 0; i < 6; i++) {
                int nz = cur.z + dz[i];
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nz < 0 || nz >= height || nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }

                if (time[nz][nx][ny] >= 0) {
                    continue;
                }

                if (building[nz][nx][ny] == '#') {
                    continue;
                }

                time[nz][nx][ny] = time[cur.z][cur.x][cur.y] + 1;
                deque.offer(new Pair(nz, nx, ny));
            }
        }
    }

    static class Pair {
        int z;
        int x;
        int y;

        Pair(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}
