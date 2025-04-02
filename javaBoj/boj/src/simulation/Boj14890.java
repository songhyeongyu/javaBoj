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
    static int[][] colBoard;
    static int[][] rowBoard;
    static boolean[][] colBridge;
    static boolean[][] rowBridge;

    public static void main(String[] args) throws IOException {
        Boj14890 process = new Boj14890();
        process.run();
    }

    private void run() throws IOException {
        init();
        makeBridgeArr(colBoard, colBridge, rowBoard, rowBridge);

        int r = countRoad(rowBridge);
        int c = countRoad(colBridge);

        System.out.println(r+c);

    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        colBoard = new int[N][N];
        rowBoard = new int[N][N];
        colBridge = new boolean[N][N];
        rowBridge = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                colBoard[i][j] = num;
                rowBoard[j][i] = num;
            }
        }


    }

    private void makeBridgeArr(int[][] colBoard, boolean[][] colBridge, int[][] rowBoard, boolean[][] rowBridge) {
        for (int i = 0; i < N; i++) {
            boolean[] isColMakeBridge = new boolean[N];
            boolean[] isRowMakeBridge = new boolean[N];
            checkArr(colBoard[i], i, colBridge,isColMakeBridge);
            checkArr(rowBoard[i], i, rowBridge,isRowMakeBridge);
        }



    }

    private void checkArr(int[] board, int idx,boolean[][] bridge,boolean[] makeBridge) {
        for (int i = 0; i < N-1; i++) {
            int dif = board[i] - board[i + 1];
            if (Math.abs(dif) > 1) {
                continue;
            }
            if (i == N-2 && Math.abs(dif) == 1) {
                if (board[i + 1] > board[i]) {
                    int standard = board[i + 1];
                    for (int j = i; j > i - L; j--) {
                        if (j < 0) {
                            bridge[idx][i + 1] = false;
                            break;
                        }
                        if (standard - board[j] == 1) {
                            bridge[idx][j] = true;
                            bridge[idx][i + 1] = true;
                        } else if (Math.abs(board[i + 1] - board[j]) > 1) {
                            bridge[idx][i + 1] = false;
                            break;
                        }
                    }
                }
                if (L == 1) {
                    if (!makeBridge[i]) {
                        bridge[idx][i + 1] = true;
                    }
                }
            }
            if (dif == 0) {
                if (i == N - 2) {
                    bridge[idx][i+1] = true;
                }
                bridge[idx][i] = true;
            }
            else if (dif == 1) {
                for (int j = i+1; j <= i + L; j++) {
                    if (j >= N) {
                        bridge[idx][i] = false;
                        break;
                    } else if (board[i] - board[j] == 1) {
                        if (makeBridge[j]) {
                            bridge[idx][i] = false;
                            break;
                        }

                        bridge[idx][i] = true;
                        makeBridge[j] = true;

                    }
                    else if(Math.abs(board[i] - board[j]) > 1){
                        bridge[idx][i] = false;
                        break;
                    }
                }
            } else if (dif == -1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0) {
                        bridge[idx][i] = false;
                        break;
                    }
                    else if (board[i+1] - board[j] == 1) {
                        if (makeBridge[j]) {
                            bridge[idx][i] = false;
                            break;
                        }
                        bridge[idx][j] = true;
                        makeBridge[j] = true;
                    }else if(Math.abs(board[i+1] - board[j]) > 1){
                        bridge[idx][i] = false;
                        break;
                    }
                }
            }
        }
    }

    private int countRoad(boolean[][] board) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                if (!board[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }

        }
        return count;
    }





}




