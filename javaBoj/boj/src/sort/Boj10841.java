package sort;

import java.util.*;
import java.io.*;


public class Boj10841{
    static ArrayList<User> users = new ArrayList<>();
    static int N;


    public static void main(String[] args) throws IOException {
        Boj10841 process = new Boj10841();
        process.run();

    }

    public void run() throws IOException {
        init();
        sortUsers();
        printUser();
    }

    public void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            users.add(new User(age, name, i));
        }
        sortUsers();

    }

    public void sortUsers() {
        Collections.sort(users, new Comparator<User>(){
            @Override
            public int compare(User o1, User o2) {
                if (o1.age == o2.age) {
                    return Integer.compare(o1.idx, o2.idx);
                }
                return Integer.compare(o1.age, o2.age);
            }
        });
    }

    public void printUser() {
        for (User user : users) {
            System.out.println(user.age + " " + user.name);
        }
    }
    static class User {
        int age;
        String name;
        int idx;

        public User(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }
    }

}

