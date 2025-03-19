package simulation;

import java.util.*;
import java.io.*;

public class Boj14503 {

    static int N;
    static int M;
    static int x;
    static int y;
    static int direct;

//    static int[] dx = {-1, 0, 1, 0};
//    static int[] dy = {0, 1, 0, -1};

    static char[][] board;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        Boj14503 process = new Boj14503();
        process.run();
    }

    private void run() throws IOException {
        init();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        direct = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = st.nextToken().charAt(0);
                distance[i][j] = -1;
            }
        }
        distance[x][y] = 1;
        if (direct == 0) {
            searchFromNorth();
        } else if (direct == 1) {
            searchFromEast();
        } else if (direct == 2) {
            searchFromWest();
        }else {
            searchFromSouth();
        }
        System.out.println(Arrays.deepToString(distance));
    }

    // 1. search around
    // 모든 방향에 대해서 방향을 바꿔줘야 된다.
    // 바꾼 다음에 방향에 대해서 다시 최신화

    private void searchFromNorth() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        if (bfs(dx, dy)) return;

        goBack();

    }

    private void searchFromWest() {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        if (bfs(dx, dy)) return;

        goBack();
    }

    private void searchFromSouth() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        if (bfs(dx, dy)) return;

        goBack();
    }

    private void searchFromEast() {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        if (bfs(dx, dy)) return;

        goBack();
    }

    private static boolean bfs(int[] dx, int[] dy) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if (board[nx][ny] == '1' || distance[nx][ny] > -1) {
                continue;
            }

            //여기서 주변 안넘어가면 다른 함수
            distance[nx][ny] = distance[x][y] + 1;
            x = nx;
            y = ny;
            changeDirection(i);
            return true;
        }
        return false;
    }

    private static void changeDirection(int i) {
        if (direct == 0) {
            if (i == 1) {
                direct = 2;
            } else if (i == 2) {
                direct = 3;
            } else if (i == 3) {
                direct = 1;
            }

        } else if (direct == 2) {
            if (i == 0) {
                direct = 2;
            } else if (i == 1) {
                direct = 3;
            } else if (i == 2) {
                direct = 1;
            } else if (i == 3) {
                direct = 0;
            }
        } else if (direct == 3) {
            if (i == 0) {
                direct = 3;
            } else if (i == 1) {
                direct = 1;
            } else if (i == 2) {
                direct = 0;
            } else if (i == 3) {
                direct = 2;
            }
        } else if (direct == 1) {
            if (i == 0) {
                direct = 1;
            } else if (i == 1) {
                direct = 0;
            } else if (i == 2) {
                direct = 2;
            } else if (i == 3) {
                direct = 3;
            }
        }
    }

    private void goBack() {
        if (direct == 0) {
            x += 1;
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            if (bfs(dx, dy)) {
                return;
            }
        }

        else if (direct == 1) {
            y += 1;
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            if (bfs(dx, dy)) {
                return;
            }
        }

        else if (direct == 2) {
            x -= 1;
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, -1, 0, 1};
            if (bfs(dx, dy)) {
                return;
            }
        } else if (direct == 3) {
            y -= 1;
            int[] dx = {0, -1, 0, 1};
            int[] dy = {-1, 0, 1, 0};

            if (bfs(dx, dy)) {
                return;
            }
        }
    }

    //2. 만약 후진해야 될 경우
}
