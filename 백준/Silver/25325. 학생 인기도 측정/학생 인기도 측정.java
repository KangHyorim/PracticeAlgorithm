import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = st.nextToken();
            map.put(str, 0);
        }

        for (int i = 0; i < n; i++) {
            String[] likes = br.readLine().split(" ");
            for (String like : likes) {
                map.put(like, map.get(like) + 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort((o1, o2) -> {
            int v1 = map.get(o1);
            int v2 = map.get(o2);

            if (v1 == v2) {
                return o1.compareTo(o2);
            }
            return v2 - v1;
        });

        StringBuilder sb = new StringBuilder();
        for (String key : keySet) {
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }
        System.out.println(sb);
    }
}
