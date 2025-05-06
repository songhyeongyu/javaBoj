import java.util.*;
class 베스트앨범 {
    static Map<String,List<Node>> map = new LinkedHashMap<>();
    static Map<String,Integer> compareMap = new LinkedHashMap<>();
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < genres.length;i++){
            map.putIfAbsent(genres[i],new ArrayList<>());
            map.get(genres[i]).add(new Node(i,plays[i]));
            compareMap.putIfAbsent(genres[i],0);
            compareMap.put(genres[i], compareMap.get(genres[i]) + plays[i]);
        }

        for(List<Node> lst : map.values()){
            Collections.sort(lst, (n1,n2) -> n2.play - n1.play);
        }


        List<Map.Entry<String,Integer>> sorted = new ArrayList<>(compareMap.entrySet());
        Collections.sort(sorted,(c1,c2) -> Integer.compare(c2.getValue(),c1.getValue()));

        for(Map.Entry<String, Integer> s : sorted){
            if(map.containsKey(s.getKey())){
                List<Node> tmp = map.get(s.getKey());
                if(tmp.size() == 1){
                    answer.add(tmp.get(0).idx);
                    continue;
                }

                for(int i = 0; i< 2; i++){
                    answer.add(tmp.get(i).idx);
                }
            }
        }


        return answer;
    }

    static class Node{
        int idx;
        int play;

        public Node(int idx, int play){
            this.idx = idx;
            this.play = play;
        }

        @Override
        public String toString(){
            return "(" + idx + " " + play + ")";
        }
    }
}