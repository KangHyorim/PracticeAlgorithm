import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < N; i++) {
            double S = sc.nextDouble();
            int A = sc.nextInt();
            int T = sc.nextInt();
            int M = sc.nextInt();

            total += S * (1.0 + 1.0 / A) * (1.0 + (double) M / T) / 4.0;
        }

        int P = sc.nextInt();
        int rank = 1;

        for (int i = 0; i < P; i++) {
            double R = sc.nextDouble();
            if (R > total) rank++;
        }

        boolean isGod = rank <= (P + 1) * 0.15;

        if (isGod) {
            System.out.printf("The total score of Younghoon \"The God\" is %.2f.%n", total);
        } else {
            System.out.printf("The total score of Younghoon is %.2f.%n", total);
        }
    }
}