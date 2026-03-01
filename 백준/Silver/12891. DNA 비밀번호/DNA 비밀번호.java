import java.io.*;
import java.util.*;

public class Main {

    static int[] minCnt = new int[4];   // 최소 필요 개수
    static int[] curCnt = new int[4];   // 현재 윈도우 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minCnt[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        // 초기 윈도우 설정
        for (int i = 0; i < P; i++) {
            add(dna.charAt(i));
        }

        if (check()) answer++;

        // 슬라이딩
        for (int i = P; i < S; i++) {
            add(dna.charAt(i));
            remove(dna.charAt(i - P));

            if (check()) answer++;
        }

        System.out.println(answer);
    }

    static void add(char c) {
        if (c == 'A') curCnt[0]++;
        else if (c == 'C') curCnt[1]++;
        else if (c == 'G') curCnt[2]++;
        else if (c == 'T') curCnt[3]++;
    }

    static void remove(char c) {
        if (c == 'A') curCnt[0]--;
        else if (c == 'C') curCnt[1]--;
        else if (c == 'G') curCnt[2]--;
        else if (c == 'T') curCnt[3]--;
    }

    static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (curCnt[i] < minCnt[i]) return false;
        }
        return true;
    }
}