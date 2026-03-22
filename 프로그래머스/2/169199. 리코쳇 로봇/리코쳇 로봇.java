import java.util.*;

class Solution {
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};

    public int solution(String[] board) {
        int h = board.length;
        int w = board[0].length();
        int[] start = new int[2];
        
        // 1. 시작 위치(R) 찾기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        return bfs(board, start, h, w);
    }

    public int bfs(String[] board, int[] start, int h, int w) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];

        // {y, x, 이동 횟수}
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int y = curr[0];
            int x = curr[1];
            int count = curr[2];

            // 목표 지점(G)에 도달한 경우
            if (board[y].charAt(x) == 'G') {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y;
                int nextX = x;

                // 2. 미끄러지기: 벽이나 'D'를 만나기 직전까지 이동
                while (true) {
                    int ty = nextY + dy[i];
                    int tx = nextX + dx[i];

                    if (ty < 0 || ty >= h || tx < 0 || tx >= w || board[ty].charAt(tx) == 'D') {
                        break;
                    }
                    nextY = ty;
                    nextX = tx;
                }

                // 3. 멈춘 위치가 처음 방문하는 곳이라면 큐에 삽입
                if (!visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX, count + 1});
                }
            }
        }

        return -1; // 목표 지점에 도달할 수 없는 경우
    }
}