class Solution {
    // 하, 우, 좌상
    int[] dx = {1, 0, -1};
    int[] dy = {0, 1, -1};
    
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int len = n * (n + 1) / 2;
        int[] answer = new int[len];
        
        int x = -1; 
        int y = 0;
        int num = 1;
        
        for(int i = 0; i < n; i++){
            int dir = i % 3;
            for(int j = i; j < n; j++){
                x += dx[dir];
                y += dy[dir];
                
                arr[x][y] = num++;
            }
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}