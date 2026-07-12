import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        int MAX = 1000;
        int[] A = new int[MAX + 1];

        A[0] = 1;
        A[1] = 1;

        for (int i = 2; i <= MAX; i++) {
            HashSet<Integer> forbidden = new HashSet<>();

            for (int k = 1; k * 2 <= i; k++) {
                int val = 2 * A[i - k] - A[i - 2 * k];
                if (val > 0) forbidden.add(val);
            }

            int x = 1;
            while (true) {
                if (!forbidden.contains(x)) {
                    A[i] = x;
                    break;
                }
                x++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (TC-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(A[n]).append("\n");
        }

        System.out.print(sb);
    }
}