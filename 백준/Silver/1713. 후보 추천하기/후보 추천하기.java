import java.io.*;
import java.util.*;


public class Main {
    static class Student {
        int num;
        int vote;
        int time;

        Student(int num, int vote, int time) {
            this.num = num;
            this.vote = vote;
            this.time = time;
        }
    }

    static int N;
    static List<Student> frame = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 사진 틀의 개수
        int cnt = Integer.parseInt(br.readLine());  // 전체 학생의 총 추천 횟수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int recommend = Integer.parseInt(st.nextToken());
            addCandidate(recommend, i);
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(frame, (o1, o2) -> o1.num - o2.num);
        for (Student s : frame) sb.append(s.num).append(" ");

        System.out.println(sb.toString());
    }

    private static void addCandidate(int num, int time) {
        if (isExist(num)) {
            return;
        }

        if (!isFull()) {
            frame.add(new Student(num, 1, time));
            return;
        }

        removeCandidate();
        frame.add(new Student(num, 1, time));

    }

    private static boolean isExist(int num) {
        for (Student s : frame) {
            if (s.num == num) {
                s.vote++;
                return true;
            }
        }
        return false;
    }

    private static boolean isFull() {
        if (frame.size() >= N) return true;

        return false;
    }

    private static void removeCandidate() {
        Collections.sort(frame, (o1, o2) -> {
            if (o1.vote != o2.vote) return o1.vote - o2.vote;
            return o1.time - o2.time;
        });

        frame.remove(0);
    }
}
