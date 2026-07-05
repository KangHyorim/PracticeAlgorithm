import java.io.*;
import java.util.*;

public class Solution {

    static int H, W;
    static ArrayList<Integer>[] graph;
    static int[] match;
    static boolean[] visited;

    static boolean dfs(int u) {
        for (int v : graph[u]) {
            if (visited[v]) continue;
            visited[v] = true;

            if (match[v] == -1 || dfs(match[v])) {
                match[v] = u;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            char[][] board = new char[H][W];

            boolean[] rowForbidden = new boolean[H];
            boolean[] colForbidden = new boolean[W];

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                board[i] = s.toCharArray();

                for (int j = 0; j < W; j++) {
                    if (board[i][j] == '.') {
                        rowForbidden[i] = true;
                        colForbidden[j] = true;
                    }
                }
            }

            boolean[] rowForced = new boolean[H];
            boolean[] colForced = new boolean[W];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (board[i][j] != '#') continue;

                    if (rowForbidden[i]) colForced[j] = true;
                    if (colForbidden[j]) rowForced[i] = true;
                }
            }

            int forced = 0;
            for (boolean b : rowForced) if (b) forced++;
            for (boolean b : colForced) if (b) forced++;

            graph = new ArrayList[H];
            for (int i = 0; i < H; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < H; i++) {
                if (rowForbidden[i] || rowForced[i]) continue;

                for (int j = 0; j < W; j++) {
                    if (board[i][j] != '#') continue;
                    if (colForbidden[j] || colForced[j]) continue;

                    graph[i].add(j);
                }
            }

            match = new int[W];
            Arrays.fill(match, -1);

            int maxMatch = 0;

            for (int i = 0; i < H; i++) {
                if (rowForbidden[i] || rowForced[i]) continue;

                visited = new boolean[W];
                if (dfs(i)) maxMatch++;
            }

            sb.append(forced + maxMatch).append('\n');
        }

        System.out.print(sb);
    }
}