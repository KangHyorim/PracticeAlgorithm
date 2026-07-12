import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            String s = br.readLine();

            boolean[] exist = new boolean[10];

            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(i) - '0';
                exist[num] = !exist[num];   // 토글
            }

            int cnt = 0;
            for (boolean b : exist) {
                if (b) cnt++;
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}