package simulation;

import java.util.*;
import java.io.*;

//List로 구현하는게 더 나을것같기도 하고
public class Boj14891 {
    static List<List<Character>> wheel;
    static int N;
    private static final int TWO = 2;
    private static final int SIX = 6;

    public static void main(String[] args) throws IOException {
        Boj14891 process = new Boj14891();
        process.run();

    }

    private void run() throws IOException {
        init();
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        wheel = new ArrayList<>(4);


        for (int i = 0; i < 4; i++) {
            wheel.add(new ArrayList<>());
        }

        for (int i = 0; i < 4; i++) {
            String input = bf.readLine();

            for (char c : input.toCharArray()) {
                wheel.get(i).add(c);
            }

        }

        System.out.println();
        for (List<Character> characters : wheel) {
            System.out.println(Arrays.toString(characters.toArray()));
        }
        System.out.println("-".repeat(20));
        N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());


            boolean[] isTurn = new boolean[3];
            if (index == 0) {
                isTurn = decideTurnFromZero(index);
            } else if (index == 1) {
                isTurn = decideTurnFromOne(index);
            } else if (index == 2) {
                isTurn = decideTurnFromTwo(index);
            } else {
                isTurn = decideTurnFromThree(index);
            }

            //왔다 갔다 회전해야된다.

            if (direction == 1) {

                if (index == 0) {
                    turnZero(isTurn);
                }

                else if (index == 1) {
                    turnOne(isTurn);
                }

                else if (index == 2) {
                    turnTwo(isTurn);
                }

                else if (index == 3) {
                    turnThree(isTurn);
                }
            }
            else{

                if (index == 0) {
                    turnZeroByLeft(isTurn);
                }

                else if (index == 1) {
                    turnOneByLeft(isTurn);
                }

                else if (index == 2) {
                    turnTwoByLeft(isTurn);
                }

                else if (index == 3) {
                    turnThreeByLeft(isTurn);
                }
            }


            System.out.println(index + " " + direction);
            for (List<Character> characters : wheel) {
                System.out.println(Arrays.toString(characters.toArray()));
            }

        }
    }

    private void turnThreeByLeft(boolean[] isTurn) {
        turnLeft(3);
        if (isTurn[2]) {
            turnRight(2);
            if (isTurn[1]) {
                turnLeft(1);
                if (isTurn[0]) {
                    turnRight(0);
                }
            }
        }
    }

    private void turnTwoByLeft(boolean[] isTurn) {
        turnLeft(2);
        if (isTurn[2]) {
            turnRight(3);
        }
        if (isTurn[1]) {
            turnRight(1);
            if (isTurn[0]) {
                turnLeft(0);
            }
        }
    }

    private void turnOneByLeft(boolean[] isTurn) {
        turnLeft(1);
        if (isTurn[0]) {
            turnRight(0);
        }

        if (isTurn[1]) {
            turnRight(2);
            if (isTurn[2]) {
                turnLeft(3);
            }
        }
    }

    private void turnZeroByLeft(boolean[] isTurn) {
        turnLeft(0);
        if (isTurn[0]) {
            turnRight(1);
            if (isTurn[1]) {
                turnLeft(2);
                if (isTurn[2]) {
                    turnRight(3);
                }
            }
        }
    }

    private void turnThree(boolean[] isTurn) {
        turnRight(3);
        if (isTurn[2]) {
            turnLeft(2);
            if (isTurn[1]) {
                turnRight(1);
                if (isTurn[0]) {
                    turnLeft(0);
                }
            }
        }
    }

    private void turnTwo(boolean[] isTurn) {
        turnRight(2);
        if (isTurn[1]) {
            turnLeft(1);
            if (isTurn[0]) {
                turnRight(0);
            }
        }

        if (isTurn[2]) {
            turnLeft(3);
        }
    }

    private void turnOne(boolean[] isTurn) {
        turnRight(1);
        if (isTurn[0]) {
            turnLeft(0);
        }
        if (isTurn[1]) {
            turnLeft(2);
            if (isTurn[2]) {
                turnRight(3);
            }
        }
    }

    private void turnZero(boolean[] isTurn) {
        turnRight(0);
        int index = 1;
        for (int i = 0; i < 3; i++) {
            if(isTurn[i]) {
                if (i % 2 != 0) {
                    turnLeft(index);
                } else {
                    turnRight(index);
                }
                index++;
            }
            else{
                break;
            }
        }
    }

    private boolean[] decideTurnFromZero(int index) {
        boolean[] isTurn = new boolean[3];
        int next = 1;

        for (int i = 0; i < 3; i++) {
            if (wheel.get(index).get(TWO) != wheel.get(next).get(SIX)) {
                isTurn[i] = true;
                index++;
                next++;

//                if (next > wheel.size()) {
//                    break;
//                }
            }
            else {
                break;
            }
        }

        return isTurn;
    }

    private boolean[] decideTurnFromOne(int index) {
        boolean[] isTurn = new boolean[3];
        int next = 2;
        int previous = 0;
        if (wheel.get(index).get(SIX) != wheel.get(previous).get(TWO)) {
            isTurn[0] = true;
        }

        for (int i = 1; i < 3; i++) {
            if (wheel.get(index).get(TWO) != wheel.get(next).get(SIX)) {
                isTurn[i] = true;
                index++;
                next++;
            }
            else{
                break;
            }
        }

        return isTurn;
    }


    private boolean[] decideTurnFromTwo(int index) {
        boolean[] isTurn = new boolean[3];
        int next = 3;
        int previous = 1;

        if (wheel.get(index).get(TWO) != wheel.get(next).get(SIX)) {
            isTurn[2] = true;
        }

        for (int i = 1; i > -1; i--) {
            if (wheel.get(index).get(SIX) != wheel.get(previous).get(TWO)) {
                isTurn[i] = true;
                index--;
                previous--;
            }
        }

        return isTurn;
    }

    private boolean[] decideTurnFromThree(int index) {
        boolean[] isTurn = new boolean[3];
        int previous = 2;

        for (int i = 2; i > -1; i--) {
            if (wheel.get(index).get(SIX) != wheel.get(previous).get(TWO)) {
                isTurn[i] = true;
                index--;
                previous--;
            }
            else{
                break;

            }
        }


        return isTurn;
    }

    private void turnRight(int index) {
        wheel.get(index).addFirst(wheel.get(index).removeLast());
    }

    private void turnLeft(int index) {
        wheel.get(index).addLast(wheel.get(index).removeFirst());
    }






}
