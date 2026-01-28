import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');

        boolean[] used = new boolean[26];

        int cur = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);

            cur = (cur + S) % N;

            if (wheel[cur] != '?' && wheel[cur] != ch) {
                System.out.println("!");
                return;
            }

            if (wheel[cur] == '?' && used[ch - 'A']) {
                System.out.println("!");
                return;
            }

            wheel[cur] = ch;
            used[ch - 'A'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int idx = (cur - i + N) % N;
            sb.append(wheel[idx]);
        }

        System.out.println(sb.toString());
    }
}