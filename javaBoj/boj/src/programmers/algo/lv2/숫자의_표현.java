package programmers.algo.lv2;

import java.util.*;
public class 숫자의_표현 {
        static int[] arr;
        public static int solution(int n) {
            int answer = 0;
            arr = new int[n];
            for(int i = 0; i< n ; i++){
                arr[i] = i+1;
            }
            System.out.println(Arrays.toString(arr));
            answer = twoPointer(arr);
            return answer;
        }

        public static int twoPointer(int[] arr){
            int end = 1;
            int tot = 1;
            int result = 0;
            for(int st = 0; st < arr.length;st++){
                while(end < arr.length && tot <= arr.length){
                    if(tot == arr.length){
                        result++;
                        break;
                    }
                    tot += arr[end];
                    end++;

                }

                if(end==arr.length){
                    result++;
                    break;
                }

                tot -= arr[st];
            }

            return result;
        }


}
