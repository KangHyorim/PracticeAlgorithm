import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());


        long num = 1;
        long den = arr[0];

        for (int i = 1; i < N; i++) {
            num = num * arr[i] + den;
            den = den * arr[i];

            long g = gcd(num, den);
            num /= g;
            den /= g;
        }

        System.out.println(den + "/" + num);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
