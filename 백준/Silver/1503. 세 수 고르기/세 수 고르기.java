import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 자연수 (1 ~ 1000)
        int M = Integer.parseInt(st.nextToken());   // 집합 크기 (0 ~ 50)
        boolean[] excluded = new boolean[1002];

        if (M > 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                int n = Integer.parseInt(st.nextToken());
                excluded[n] = true;
            }
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i <= 1001; i++) {
            if (excluded[i]) continue;

            for (int j = 1; j <= 1001; j++) {
                if (excluded[j]) continue;

                for (int k = 1; k <= 1001; k++) {
                    if (excluded[k]) continue;

                    int val = i * j * k;
                    int diff = Math.abs(N - val);

                    minDiff = Math.min(minDiff, diff);

                    if (N < val) break;
                }
            }
        }
        System.out.println(minDiff);
    }
}
