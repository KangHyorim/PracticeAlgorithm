import java.io.*;
import java.util.*;

public class Solution {

    static final int OFFSET = 5000;
    static final int BASE = 10001;

    static long key(int d1, int d2) {
        return (long) (d1 + OFFSET) * BASE + (d2 + OFFSET);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            String S = st.nextToken();

            HashMap<Long, Integer> map = new HashMap<>();

            int d1 = 0;
            int d2 = 0;

            map.put(key(0, 0), 1);

            long ans = 0;

            for (int i = 0; i < N; i++) {
                char c = S.charAt(i);

                switch (c) {
                    case 'A':
                        d1++;
                        break;
                    case 'T':
                        d1--;
                        break;
                    case 'C':
                        d2++;
                        break;
                    case 'G':
                        d2--;
                        break;
                }

                long k = key(d1, d2);

                int cnt = map.getOrDefault(k, 0);
                ans += cnt;
                map.put(k, cnt + 1);
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}