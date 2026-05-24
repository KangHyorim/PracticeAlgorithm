import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            // 압축 풀어서 전체 문자열 만들기
            StringBuilder full = new StringBuilder();
            for (int i = 0; i < N; i++) {
                char c = sc.next().charAt(0);
                int k = sc.nextInt();
                for (int j = 0; j < k; j++) full.append(c);
            }

            // 10글자씩 줄 나눠서 출력
            System.out.println("#" + t);
            String str = full.toString();
            for (int i = 0; i < str.length(); i += 10) {
                System.out.println(str.substring(i, Math.min(i + 10, str.length())));
            }
        }

        sc.close();
    }
}