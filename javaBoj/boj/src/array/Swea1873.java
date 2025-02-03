package array;

import java.util.*;
import java.io.*;

public class Swea1873 {
    static int col, row;
    static char[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            field = new char[col][row];

            Deque<Pair> deque = new LinkedList<>();

            for (int i = 0; i < col; i++) {
                String input = bf.readLine();
                for (int j = 0; j < row; j++) {
                    field[i][j] = input.charAt(j);
                    if (field[i][j] == '>' || field[i][j] == 'v' || field[i][j] == '<' || field[i][j] == '^') {
                        deque.offer(new Pair(i, j));
                    }
                }
            }

            int N = Integer.parseInt(bf.readLine());
            String cmd = bf.readLine();

            for (char c : cmd.toCharArray()) {
                Pair cur = deque.pollFirst();
                if (cur == null || cur.x < 0 || cur.x >= col || cur.y < 0 || cur.y >= row) {
                    continue;
                }

                if (c == 'U') {
                    field[cur.x][cur.y] = '^';
                    if (cur.x - 1 >= 0 && field[cur.x - 1][cur.y] == '.') {
                        field[cur.x - 1][cur.y] = '^';
                        field[cur.x][cur.y] = '.';
                        deque.offerFirst(new Pair(cur.x - 1, cur.y));
                    } else {
                        deque.offerFirst(cur);
                    }

                } else if (c == 'D') {
                    field[cur.x][cur.y] = 'v';
                    if (cur.x + 1 < col && field[cur.x + 1][cur.y] == '.') {
                        field[cur.x + 1][cur.y] = 'v';
                        field[cur.x][cur.y] = '.';
                        deque.offerFirst(new Pair(cur.x + 1, cur.y));
                    } else {
                        deque.offerFirst(cur);
                    }

                } else if (c == 'L') {
                    field[cur.x][cur.y] = '<';
                    if (cur.y - 1 >= 0 && field[cur.x][cur.y - 1] == '.') {
                        field[cur.x][cur.y - 1] = '<';
                        field[cur.x][cur.y] = '.';
                        deque.offerFirst(new Pair(cur.x, cur.y - 1));
                    } else {
                        deque.offerFirst(cur);
                    }

                } else if (c == 'R') {
                    field[cur.x][cur.y] = '>';
                    if (cur.y + 1 < row && field[cur.x][cur.y + 1] == '.') {
                        field[cur.x][cur.y + 1] = '>';
                        field[cur.x][cur.y] = '.';
                        deque.offerFirst(new Pair(cur.x, cur.y + 1));
                    } else {
                        deque.offerFirst(cur);
                    }

                } else if (c == 'S') {
                    if (field[cur.x][cur.y] == '^') {
                        int shoot = cur.x;
                        while (shoot > 0) {
                            shoot--;
                            if (field[shoot][cur.y] == '*') {
                                field[shoot][cur.y] = '.';
                                break;
                            }
                            if (field[shoot][cur.y] == '#') {
                                break;
                            }
                        }
                    } else if (field[cur.x][cur.y] == 'v') {
                        int shoot = cur.x;
                        while (shoot < col - 1) {
                            shoot++;
                            if (field[shoot][cur.y] == '*') {
                                field[shoot][cur.y] = '.';
                                break;
                            }
                            if (field[shoot][cur.y] == '#') {
                                break;
                            }
                        }
                    } else if (field[cur.x][cur.y] == '<') {
                        int shoot = cur.y;
                        while (shoot > 0) {
                            shoot--;
                            if (field[cur.x][shoot] == '*') {
                                field[cur.x][shoot] = '.';
                                break;
                            }
                            if (field[cur.x][shoot] == '#') {
                                break;
                            }
                        }
                    } else if (field[cur.x][cur.y] == '>') {
                        int shoot = cur.y;
                        while (shoot < row - 1) {
                            shoot++;
                            if (field[cur.x][shoot] == '*') {
                                field[cur.x][shoot] = '.';
                                break;
                            }
                            if (field[cur.x][shoot] == '#') {
                                break;
                            }
                        }
                    }
                    deque.offerFirst(cur);
                }
            }

            sb.append("#").append(t + 1).append(" ");
            for (char[] line : field) {
                sb.append(new String(line)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
