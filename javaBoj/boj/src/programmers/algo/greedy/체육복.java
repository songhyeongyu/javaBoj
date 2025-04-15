import java.util.*;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = findCloth(n,lost,reserve);
        System.out.println(Arrays.toString(student));

        for(int i = 1 ; i < student.length ; i++){
            if(i == student.length-1){
                break;
            }
            if(student[i] == 0){
                if(student[i-1] > 1){
                    student[i-1] -= 1;
                    student[i] += 1;
                }else if(student[i+1] > 1){
                    student[i+1] -= 1;
                    student[i] += 1;
                }
            }
        }

        for(int s : student){
            if(s>0){
                answer++;
            }
        }


        return answer;
    }

    private int[] findCloth(int n, int[] lost, int[] reserve){
        int[] temp = new int[n+2];
        for(int i = 0 ; i < lost.length;i++){
            temp[lost[i]] -= 1;
        }
        for(int i = 0 ; i < reserve.length;i++){
            temp[reserve[i]] += 1;
        }




        for(int i = 1; i<= n; i++){
            temp[i] += 1;
        }

        return temp;
    }

}