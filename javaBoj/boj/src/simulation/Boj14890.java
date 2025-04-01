package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj14890 {
    static int N;
    static int L;

    static boolean[][] colUsed;


    public static void main(String[] args) throws IOException {

        Boj14890 process = new Boj14890();
        process.run();
    }

    private void run() throws IOException {
        init();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        colUsed = new boolean[N][N];
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        findColBridge(board);

    }

    private void findColBridge(int[][] colBoard) {

        }
    }

  

    //길이 만큼만 괜찮은지 보면 될듯?


