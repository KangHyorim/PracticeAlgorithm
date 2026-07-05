import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 1) {
                sb.append("0\n");
                continue;
            }

            if (x % 2 == 0) {
                for (int i = 0; i < x / 2; i++)
                    sb.append('8');
            } else {
                sb.append('4');
                for (int i = 0; i < x / 2; i++)
                    sb.append('8');
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}