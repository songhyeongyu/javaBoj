package programmers.algo.sort;

import java.util.*;

class H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        List<Node> hIndex = calculateHindex(citations);
        answer = findHindex(hIndex);

        return answer;
    }

    private int findHindex(List<Node> index){
        int ans = 0;
        for(Node node : index){
            if(node.num >= node.count){
                ans = node.count;
                break;
            }

        }
        return ans;
    }

    private List<Node> calculateHindex(int[] citations){
        List<Node> temp = new ArrayList<>();

        for(int i = 0 ; i < citations.length;i++){
            temp.add(new Node(citations[i], citations.length - i));
        }
        return temp;
    }

    static class Node{
        int num;
        int count;

        public Node(int num, int count){
            this.num = num;
            this.count = count;
        }
    }


}