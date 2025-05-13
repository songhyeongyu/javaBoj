package programmers.algo.lv2;

public class 다음의_큰_숫자 {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toBinaryString(n);
        int standard = countOne(s);

        while(true){
            n++;
            String temp = Integer.toBinaryString(n);
            int result = countOne(temp);

            if(standard == result){
                break;
            }
        }

        return n;
    }

    public int countOne(String str){
        char[] temp = str.toCharArray();
        int cnt = 0;

        for(int i = 0; i<temp.length;i++){
            if(temp[i]=='1'){
                cnt++;
            }
        }
        return cnt;
    }
}
