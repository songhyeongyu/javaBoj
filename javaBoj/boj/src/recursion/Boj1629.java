package recursion;


import java.io.*;
import java.util.*;

public class Boj1629 {


    public static void main(String[] args) throws IOException {
        Boj1629 process = new Boj1629();

        process.init();

    }

    public void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long result = recursion(a, b, c);

        System.out.println(result);

    }




    public long recursion(int a, int b, int c) {
        if(b == 1) return a % c;
        long val = recursion(a, b / 2, c);
        val = val * val % c;
        if(b%2 ==0) return val;
        return val * a % c;

    }
}
