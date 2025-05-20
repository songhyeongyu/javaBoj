package programmers.algo.lv2;
import java.util.*;
import java.math.*;
public class n개의_최소공배수 {
        public int solution(int[] arr) {
            PriorityQueue<BigInteger> pq = new PriorityQueue<>();
            for(int a : arr){
                pq.offer(BigInteger.valueOf(a));
            }

            while(pq.size() != 1){
                BigInteger first = pq.poll();
                BigInteger second = pq.poll();

                BigInteger gcd = first.gcd(second);

                BigInteger lcm = first.multiply(second).divide(gcd);
                pq.offer(lcm);
            }


            return pq.poll().intValue();
        }
}
