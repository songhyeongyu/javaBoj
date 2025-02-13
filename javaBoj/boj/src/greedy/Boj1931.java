package greedy;

import java.util.*;
import java.io.*;

public class Boj1931 {
    private static int N;
    private static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        Boj1931 process = new Boj1931();
        process.run();
    }

    private void run() throws IOException {
        init();
        sortRoom();
        searchRoom();
    }

    private void init() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            rooms.add(new Room(start, end));
        }

    }

    private static void sortRoom() {
        Collections.sort(rooms, new Comparator<Room>(){
            @Override
            public int compare(Room r1, Room r2) {
                if (r1.ed == r2.ed) {
                    return Integer.compare(r1.st,r2.st);
                }
                return Integer.compare(r1.ed,r2.ed);
            }
        });
    }

    private void searchRoom() {
        int count = 1;
        Room selectRoom = rooms.get(0);
        for (int i = 1; i < N; i++) {
            if (selectRoom.ed <= rooms.get(i).st) {
                selectRoom = rooms.get(i);
                count++;
            }
        }
        System.out.println(count);
    }







    static class Room {
        int st;
        int ed;

        public Room(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }
    }
}
