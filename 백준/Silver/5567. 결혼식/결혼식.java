import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 0});
        visited[1] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int depth = current[1];

            if (depth >= 2) continue;

            for (int next : list[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt++;
                    queue.offer(new int[]{next, depth + 1});
                }
            }
        }
        System.out.println(cnt);
    }
}
