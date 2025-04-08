package programmers.algo.sort;

import java.util.*;
import java.io.*;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int index = 0;
        for(int[] cmd: commands){
            int[] temp = cutArray(array,cmd[0]-1,cmd[1]);
            Arrays.sort(temp);
            System.out.println(Arrays.toString(temp));
            System.out.println(temp[cmd[2]-1]);
            answer[index++] = temp[cmd[2]-1];
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private int[] cutArray(int[] arr,int first, int second){
        return Arrays.copyOfRange(arr,first,second);
    }
}
