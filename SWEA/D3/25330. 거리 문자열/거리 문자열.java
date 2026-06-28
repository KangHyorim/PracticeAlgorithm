import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine();

            int[] first = new int[10];
            int[] cnt = new int[10];
            Arrays.fill(first, -1);

            boolean ok = true;

            for (int i = 0; i < s.length(); i++) {
                int d = s.charAt(i) - '0';

                cnt[d]++;

                if (cnt[d] == 1) {
                    first[d] = i;
                } else if (cnt[d] == 2) {
                    if (i - first[d] - 1 != d) {
                        ok = false;
                        break;
                    }
                } else {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                for (int i = 0; i < 10; i++) {
                    if (cnt[i] == 1) {
                        ok = false;
                        break;
                    }
                }
            }

            System.out.println(ok ? "yes" : "no");
        }
    }
}