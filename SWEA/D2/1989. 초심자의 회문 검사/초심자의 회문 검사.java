import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            String str = sc.next();

            int left = 0;
            int right = str.length() - 1;
            int result = 1;

            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    result = 0;
                    break;
                }
                left++;
                right--;
            }

            System.out.println("#" + tc + " " + result);
        }

        sc.close();
    }
}