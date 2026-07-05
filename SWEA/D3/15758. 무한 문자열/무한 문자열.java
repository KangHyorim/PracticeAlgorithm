import java.io.*;
import java.util.*;

public class Solution {

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            String t = st.nextToken();

            int lenS = s.length();
            int lenT = t.length();

            int lcm = lenS / gcd(lenS, lenT) * lenT;

            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();

            while (a.length() < lcm) a.append(s);
            while (b.length() < lcm) b.append(t);

            sb.append("#").append(tc).append(" ");

            if (a.toString().equals(b.toString()))
                sb.append("yes");
            else
                sb.append("no");

            sb.append('\n');
        }

        System.out.print(sb);
    }
}