import java.io.*;
import java.util.*;

public class Main {
    static char[][] board = new char[12][6];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) board[i] = br.readLine().toCharArray();

        int cnt = 0;
        while (true) {
            boolean isPop = false;
            visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (board[i][j] != '.' && !visited[i][j]) {
                        if (bfs(i, j)) {
                            isPop = true;
                        }
                    }
                }
            }

            if (!isPop) break;
            cnt++;
            applyGravity();
        }
        System.out.println(cnt);
    }

    private static boolean bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();

        queue.offer(new int[]{r, c});
        list.add(new int[]{r, c});
        visited[r][c] = true;
        char color = board[r][c];

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dx[d];
                int nc = curr[1] + dy[d];

                if (nr >= 0 && nc >= 0 && nr < 12 && nc < 6) {
                    if (!visited[nr][nc] && board[nr][nc] == color) {
                        list.add(new int[]{nr, nc});
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        if (list.size() >= 4) {
            for (int[] pos : list) {
                board[pos[0]][pos[1]] = '.';
            }
            return true;
        }
        return false;
    }

    private static void applyGravity() {
        for (int j = 0; j < 6; j++) {
            Queue<Character> puyo = new ArrayDeque<>();

            for (int i = 11; i >= 0; i--) {
                if (board[i][j] != '.') {
                    puyo.offer(board[i][j]);
                }
            }

            for (int i = 11; i >= 0; i--) {
                if (!puyo.isEmpty()) {
                    board[i][j] = puyo.poll();
                } else {
                    board[i][j] = '.';
                }
            }
        }
    }
}
