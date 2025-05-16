package programmers.algo.lv2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class 점프와_순간_이동 {


        public int solution(int n) {
            int ans = 0;

            while(n!=0){
                if(n % 2 == 0){
                    n /=2;
                }
                else{
                    n -= 1;
                    ans++;
                }
            }


            return ans;
        }
}
