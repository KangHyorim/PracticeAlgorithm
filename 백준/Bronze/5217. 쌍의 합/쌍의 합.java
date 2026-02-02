import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine().trim());

            out.append("Pairs for ").append(n).append(": ");

            boolean first = true;
            for (int a = 1; a <= n / 2; a++) {
                int b = n - a;
                if (a < b) {
                    if (!first) out.append(", ");
                    out.append(a).append(" ").append(b);
                    first = false;
                }
            }

            out.append("\n");
        }

        System.out.print(out.toString());
    }
}
