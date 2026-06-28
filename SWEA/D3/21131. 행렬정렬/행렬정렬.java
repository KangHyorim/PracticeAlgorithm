import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] first = new int[N];
            for (int i = 0; i < N; i++) {
                first[i] = Integer.parseInt(st.nextToken());
            }

            // 나머지 행은 읽기만 한다.
            for (int i = 1; i < N; i++) {
                br.readLine();
            }

            int ans = 0;

            // 뒤에서부터 결정
            for (int i = N - 1; i >= 1; i--) {
                if (ans % 2 == 0) {
                    if (first[i] != i + 1) ans++;
                } else {
                    if (first[i] == i + 1) ans++;
                }
            }

            System.out.println(ans);
        }
    }
}