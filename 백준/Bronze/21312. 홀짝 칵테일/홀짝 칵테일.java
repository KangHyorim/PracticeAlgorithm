import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = {a, b, c};

        int productOdd = 1;
        boolean hasOdd = false;

        // 홀수만 곱해주기
        for (int x : arr) {
            if (x % 2 == 1) {
                productOdd *= x;
                hasOdd = true;
            }
        }

        // 만약 홀수가 없으면 모든 수의 곱
        if (!hasOdd) {
            System.out.println((long)a * b * c);
        } else {
            System.out.println(productOdd);
        }
    }
}
