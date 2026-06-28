import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            HashSet<Integer> A = new HashSet<>();
            HashSet<Integer> B = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                A.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                B.add(Integer.parseInt(st.nextToken()));
            }

            boolean aInB = true;
            for (int x : A) {
                if (!B.contains(x)) {
                    aInB = false;
                    break;
                }
            }

            boolean bInA = true;
            for (int x : B) {
                if (!A.contains(x)) {
                    bInA = false;
                    break;
                }
            }

            if (aInB && bInA) {
                System.out.println("=");
            } else if (aInB) {
                System.out.println("<");
            } else if (bInA) {
                System.out.println(">");
            } else {
                System.out.println("?");
            }
        }
    }
}