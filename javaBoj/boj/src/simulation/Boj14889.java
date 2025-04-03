package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14889 {
    static int N;
    static int[][] board;
    static int[] tmp;
    static boolean[] isUsed;
    static int minVal = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Boj14889 process = new Boj14889();
        process.run();
    }

    private void run() throws IOException {
        init();
        recur(0,0);
        System.out.println(minVal);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        board = new int[N][N];
        tmp = new int[N / 2];
        isUsed = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    private void recur(int cur, int st) {
        if (cur == N / 2) {
            int[] first = new int[N / 2];
            int[] second = new int[N / 2];
            boolean[] teamMate = new boolean[N];
            for (int i = 0; i < N / 2; i++) {
                first[i] = tmp[i];
                teamMate[tmp[i]] = true;
            }
            int index = 0;
            for (int i = 0; i < N; i++) {
                if (!teamMate[i]) {
                    second[index++] = i;
                }
            }
            int firstTeam = makeScore(first);
            int secondTeam = makeScore(second);
            minVal = Math.min(minVal, Math.abs(firstTeam - secondTeam));
            return;
        }
        if (cur > 0 && tmp[0] != 0) {
            return;
        }

        for (int i = st; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                tmp[cur] = i;
                recur(cur + 1,i);
                isUsed[i] = false;
            }
        }
    }

    private int makeScore(int[] team) {
        int score = 0;

        for (int i = 0; i < team.length; i++) {
            for (int j = i + 1; j < team.length; j++) {
                score += board[team[i]][team[j]] + board[team[j]][team[i]];
            }
        }
        return score;
    }
}
