package recursion;

import java.io.*;

public class Boj11729 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Boj11729 process = new Boj11729();
        process.init();
    }

    public void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        bw.write((1 << n) - 1 + "\n");
        func(1, 3, n);
        bw.flush();
        bw.close();
    }

    public void func(int a, int b, int n) throws IOException {
        if (n == 1) {
            bw.write(a + " " + b + "\n");
            return;
        }
        func(a, 6 - a - b, n - 1);
        bw.write(a + " " + b + "\n");
        func(6 - a - b, b, n - 1);
    }
}