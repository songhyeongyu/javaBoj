package programmers.algo.greedy;

import java.util.*;
public class 단속카메라 {

        static List<Node> car = new ArrayList<>();

        public int solution(int[][] routes) {
            int answer = 0;

            for(int[] r : routes){
                int st = r[0];
                int ed = r[1];

                car.add(new Node(st,ed));
            }

            Collections.sort(car,(Node n1, Node n2) -> {
                        return n1.out - n2.out;
                    }
            );
            int count = 1;


            int standard = car.get(0).out;



            for(int i = 1 ; i <car.size() ; i++){
                if(car.get(i).in <= standard){
                    continue;
                }
                count++;
                standard = car.get(i).out;
            }

            return count;
        }

        static class Node{
            int in;
            int out;

            public Node(int in, int out){
                this.in = in;
                this.out = out;
            }
        }
}
