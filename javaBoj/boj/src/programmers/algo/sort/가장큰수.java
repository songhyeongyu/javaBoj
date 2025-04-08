package programmers.algo.sort;

import java.util.*;

class 가장큰수 {
    public String solution(int[] numbers) {
        int sumVal = Arrays.stream(numbers).sum();
        if(sumVal == 0){
            return "0";
        }
        StringBuilder answer = new StringBuilder();
        List<Node> stringLst = makeStringList(numbers);

        sortStringList(stringLst);
        for(Node node : stringLst){
            answer.append(node.origin);
        }
        return answer.toString();
    }


    private void sortStringList(List<Node> lst){
        Collections.sort(lst, new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                return n2.temp.compareTo(n1.temp);
            }
        });
    }


    private List<Node> makeStringList(int[] numbers){
        List<Node> lst = new ArrayList<>();
        for(int i = 0 ; i < numbers.length ; i++){
            String c = String.valueOf(numbers[i]);
            lst.add(new Node(c.repeat(3), c));
        }

        return lst;
    }



    static class Node{
        String temp;
        String origin;

        public Node(String temp, String origin){
            this.temp = temp;
            this.origin = origin;
        }
    }
}