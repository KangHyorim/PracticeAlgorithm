import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long X = sc.nextLong();
            long Y = sc.nextLong();
            long Z = sc.nextLong();

            long A = Math.min(X, Z);
            long B = Math.min(X, Y);
            long C = Math.min(Y, Z);

            if (Math.max(A, B) == X &&
                Math.max(B, C) == Y &&
                Math.max(C, A) == Z) {

                System.out.println(A + " " + B + " " + C);
            } else {
                System.out.println("-1 -1 -1");
            }
        }

        sc.close();
    }
}