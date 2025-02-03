package linkedList;
import java.util.*;
import java.io.*;

//시간초과
public class Boj1406 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        int N = Integer.parseInt(bf.readLine());
        int cursor = input.length();
        LinkedList<Character> ll = new LinkedList<>();

        for (char c : input.toCharArray()) {
            ll.add(c);
        }


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String cmd = st.nextToken();
            System.out.println("before cursor : " + cursor);
            if (cmd.equals("P")) {
                String addChar = st.nextToken();
                char s = addChar.charAt(0);
                if (cursor > ll.size()) {
                    cursor = ll.size();
                }
                ll.add(cursor ,s);
                cursor++;
            }
            else if (cmd.equals("L")) {
                if(cursor >= 1){
                    cursor -= 1;
                } else if (cursor < 0) {
                    cursor = 0;
                }
            }
            else if (cmd.equals("D")) {
                if(cursor < input.length()){
                    cursor += 1;
                }
            }

            else if (cmd.equals("B")) {
                if (cursor < 1) {
                    continue;
                }
                ll.remove(cursor-1);
                cursor--;
            }
//            System.out.println(i+ " " + ll.toString());
//            System.out.println("after cursor : " + cursor);

        }


        for (Character c : ll) {
            System.out.print(c);
        }

    }
}
