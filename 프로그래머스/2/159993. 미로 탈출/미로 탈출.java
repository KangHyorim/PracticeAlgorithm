import java.util.*;

class Solution {
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(String[] maps) {
        int rows = maps.length;
        int cols = maps[0].length();
        map = new char[rows][cols];
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        
         for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') start = new int[]{i, j};
                if(map[i][j] == 'L') lever = new int[]{i, j};
                if(map[i][j] == 'E') exit  = new int[]{i, j};
            }
        }
        
         // S → L
        int tolever = bfs(start, lever, rows, cols);
        if(tolever == -1) return -1;
        
        // L → E
        int toexit = bfs(lever, exit, rows, cols);
        if(toexit == -1) return -1;
        
        return tolever + toexit;
    }
    
     static int bfs(int[] start, int[] end, int rows, int cols){
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
            if(x == end[0] && y == end[1]) return cnt;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위 체크 + 벽 체크 + 방문 체크
                if(nx < 0 || ny < 0 || nx >= rows || ny >= cols) continue;
                if(map[nx][ny] == 'X') continue;
                if(visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, cnt + 1});
            }
        }
        return -1;
    }
}