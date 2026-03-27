import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();
        if (firstLine == null) return;

        StringTokenizer st = new StringTokenizer(firstLine);
        if (!st.hasMoreTokens()) return;

        int n = Integer.parseInt(st.nextToken());
        long[] result = new long[n];
        int cnt = 0;

        while (cnt < n) {
            if (!st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
                continue;
            }
            result[cnt++] = reverseNumber(Long.parseLong(st.nextToken()));
        }

        Arrays.sort(result);

        StringBuilder sb = new StringBuilder();
        for (long val : result) {
            sb.append(val).append("\n");
        }
        System.out.print(sb);
    }

    private static long reverseNumber(long n) {
        long rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev;
    }
}