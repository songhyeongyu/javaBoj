package recursion;

import java.io.*;
import java.util.*;

public class Boj17478 {
    static int N;


    public static void main(String[] args) throws IOException {
        Boj17478 process = new Boj17478();
        process.run();
    }

    private void run() throws IOException {
        init();
        printHello();
        recursion(0);
    }

    private void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
    }

    private void recursion(int cnt) {

        if (N == cnt) {
            printAsk(cnt);
            printFinal(cnt);
            printAnswer(cnt);
        }else{
            printAsk(cnt);
            printMiddle(cnt);
            recursion(cnt+ 1);
            printAnswer(cnt);
        }






    }

    private void printHello() {
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
    }

    private void printAnswer(int n) {
        String prefix = "_".repeat(n * 4);
        System.out.println(prefix +"라고 답변하였지.");
    }

    private void printAsk(int n) {
        String prefix = "_".repeat(n * 4);
        System.out.println(prefix + "\"재귀함수가 뭔가요?\"");

    }

    private void printMiddle(int n) {
        String prefix = "_".repeat(n * 4);
        System.out.println(prefix + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(prefix + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(prefix + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
    }

    private void printFinal(int n) {
        String prefix = "_".repeat(n * 4);
        System.out.println(prefix + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
    }

}
