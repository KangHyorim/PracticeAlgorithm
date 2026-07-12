import java.io.*;
import java.util.*;

class Solution {

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        final int MAX = 20;
        final long DEN = 1L << MAX;

        for (int tc = 1; tc <= T; tc++) {

            String s = br.readLine();

            ArrayList<String> token = new ArrayList<>();

            int idx = 0;

            while (idx < s.length()) {
                if (s.startsWith("north", idx)) {
                    token.add("north");
                    idx += 5;
                } else {
                    token.add("west");
                    idx += 4;
                }
            }

            int m = token.size();

            long num;

            if (token.get(m - 1).equals("north"))
                num = 0;
            else
                num = 90L * DEN;

            int cnt = 1;

            for (int i = m - 2; i >= 0; i--) {

                long delta = 90L * (1L << (MAX - cnt));

                if (token.get(i).equals("north"))
                    num -= delta;
                else
                    num += delta;

                cnt++;
            }

            long g = gcd(Math.abs(num), DEN);

            long p = num / g;
            long q = DEN / g;

            System.out.print("#" + tc + " ");

            if (q == 1)
                System.out.println(p);
            else
                System.out.println(p + "/" + q);
        }
    }
}