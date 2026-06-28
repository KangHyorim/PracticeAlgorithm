import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long N = Long.parseLong(st.nextToken());
            long P = Long.parseLong(st.nextToken());

            long sum = N * (N + 1) / 2;

            if (P > sum) {
                System.out.println(sum);
                continue;
            }

            long x = (long)Math.sqrt(2L * P);

            boolean triangular = false;
            for (long k = Math.max(1, x - 2); k <= x + 2; k++) {
                if (k * (k + 1) / 2 == P) {
                    triangular = true;
                    break;
                }
            }

            System.out.println(triangular ? sum - 1 : sum);
        }
    }
}