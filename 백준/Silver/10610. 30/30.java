import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        char[] digits = N.toCharArray();

        boolean hasZero = false;
        int sum = 0;

        for (char c : digits) {
            if (c == '0') hasZero = true;
            sum += c - '0';
        }

        if (!hasZero || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(digits);

        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            sb.append(digits[i]);
        }
        System.out.println(sb.toString());
    }
}
