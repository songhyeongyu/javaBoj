package greedy;

import java.io.*;
import java.util.*;


public class Boj1744 {
    private static int N;
    private static int minusCount;
    private static int[] arrMinus;
    private static Integer[] arrPlus;
    private static int plusCount;
    private static int zeroCount;
    private static Integer[] arrPlusSorted;
    private static int[] arrMinusSorted;

    public static void main(String[] args) throws IOException {
        Boj1744 process = new Boj1744();
        process.run();
    }

    private void run() throws IOException {
        init();
        int plus = calculatePlusArr();
        int minus = calculateMinusArr();
        System.out.println(plus + minus);
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arrMinus = new int[N];
        arrPlus = new Integer[N];
        int plusIndex = 0, minusIndex = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (num <= 0) {
                if (num == 0) {
                    zeroCount++;
                    arrMinus[minusIndex++] = num;
                    continue;
                }
                minusCount++;
                arrMinus[minusIndex++] = num;
            } else{
                plusCount++;
                arrPlus[plusIndex++] = num;
            }
        }
        arrMinusSorted = Arrays.copyOf(arrMinus, zeroCount + minusCount);
        Arrays.sort(arrMinusSorted);
        arrPlusSorted = Arrays.copyOf(arrPlus, plusCount);
        Arrays.sort(arrPlusSorted, (i1, i2) -> Integer.compare(i2, i1));


    }

    private int calculateMinusArr() {
        int minus = 0;
        int ans = 0;
        int flag = minusCount;
        for (int i = 0; i < arrMinusSorted.length; i++) {
            if (arrMinusSorted[i] == 0 && zeroCount > 0) {
                zeroCount--;
                if(minus > 0){
                    continue;
                }else{
                    minus = 0;
                }
                continue;
            }
            if (flag % 2 ==1) {
                if (minusCount > 0 && minusCount % 2 == 1) {
                    minus += arrMinusSorted[i];
                } else if (minusCount > 0 && minusCount % 2 == 0) {
                    minus *= arrMinusSorted[i];
                    ans += minus;
                    minus = 0;
                }
                minusCount--;
            }
            else{
                if (minusCount > 0 && minusCount % 2 == 0) {
                    minus += arrMinusSorted[i];
                } else if (minusCount > 0 && minusCount % 2 == 1) {
                    minus *= arrMinusSorted[i];
                    ans += minus;
                    minus = 0;
                }
                minusCount--;
            }
        }
        if (minus < 0) {
            ans += minus;
        }
        return ans;
    }

    private int calculatePlusArr() {
        int plus = 0;
        int ans = 0;
        int flag = plusCount;
        for (int i = 0; i < arrPlusSorted.length; i++) {
            if (arrPlusSorted[i] == 1 || arrPlusSorted[i] == 2) {
                if(arrPlusSorted[i] == 1 ) {
                    plus++;
                    plusCount--;
                    continue;
                }
                if (arrPlusSorted[i] == 2) {
                    if (plus > 0) {
                        plus *= 2;
                        plusCount--;
                        ans += plus;
                        plus = 0;
                    }
                    else{
                        plusCount--;
                        ans += 2;
                    }
                }
                continue;

            }
            if(flag % 2 == 0) {
                if (plusCount > 0 && plusCount % 2 == 0) {
                    plus += arrPlusSorted[i];
                } else if (plusCount % 2 != 0) {
                    plus *= arrPlusSorted[i];
                    ans += plus;
                    plus = 0;
                }
                plusCount--;
            }

            else{
                if (plusCount > 0 && plusCount % 2 != 0) {
                    plus += arrPlusSorted[i];
                } else if (plusCount % 2 == 0) {
                    plus *= arrPlusSorted[i];
                    ans += plus;
                    plus = 0;
                }
                plusCount--;
            }

        }
        if (plus > 0) {
            ans += plus;
        }
        return ans;


    }
}
