import java.io.*;
import java.util.*;

public class Main {
    static long X, Y;
    static long Z;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        Z = (Y * 100) / X;

        // 절대 변하지 않는 경우
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1_000_000_000;
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            long newZ = ((Y + mid) * 100) / (X + mid);

            if (newZ > Z) {
                answer = mid;
                right = mid - 1; // 더 작은 값 탐색 (최소값)
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
