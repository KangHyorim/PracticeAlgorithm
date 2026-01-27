import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine().trim());
        int N = Integer.parseInt(br.readLine().trim());

        int sum = 0;
        int minSquare = 0;

        for (int i = 1; i * i <= N; i++) {
            int sq = i * i;
            if (sq >= M) {
                sum += sq;
                if (minSquare == 0) {
                    minSquare = sq;
                }
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(minSquare);
        }
    }
}
