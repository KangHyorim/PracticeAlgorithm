import java.io.*;
import java.util.*;

public class Solution {

    static final long MOD = 998244353L;
    static final long INV2 = 499122177L;

    static long sum(long n) {
        return (((n % MOD) * ((n + 1) % MOD)) % MOD * INV2) % MOD;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long ans = sum(a);
            ans = (ans * sum(b)) % MOD;
            ans = (ans * sum(c)) % MOD;

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}