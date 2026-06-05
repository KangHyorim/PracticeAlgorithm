import java.util.*;

class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {

        int n = storage.length;
        int m = storage[0].length();

        char[][] board = new char[n + 2][m + 2];

        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(board[i], '.');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        for (String req : requests) {

            char target = req.charAt(0);

            // 크레인
            if (req.length() == 2) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (board[i][j] == target) {
                            board[i][j] = '.';
                        }
                    }
                }
            }

            // 지게차
            else {

                boolean[][] visited = new boolean[n + 2][m + 2];
                Queue<int[]> q = new LinkedList<>();

                q.offer(new int[]{0, 0});
                visited[0][0] = true;

                List<int[]> removeList = new ArrayList<>();

                while (!q.isEmpty()) {

                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];

                    for (int d = 0; d < 4; d++) {

                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx < 0 || ny < 0 || nx >= n + 2 || ny >= m + 2)
                            continue;

                        if (visited[nx][ny])
                            continue;

                        if (board[nx][ny] == '.') {
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                        else if (board[nx][ny] == target) {
                            visited[nx][ny] = true;
                            removeList.add(new int[]{nx, ny});
                        }
                    }
                }

                for (int[] pos : removeList) {
                    board[pos[0]][pos[1]] = '.';
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] != '.') {
                    answer++;
                }
            }
        }

        return answer;
    }
}