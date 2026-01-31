class Solution {
    int[][] arr;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        arr = new int[rows][columns];
        
        int num = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = num++;
            }
        }
        
        int idx = 0;
        int[] answer = new int[queries.length];
        for(int[] q : queries){
            int x1 = q[0] - 1;
            int y1 = q[1] - 1;
            int x2 = q[2] - 1;
            int y2 = q[3] - 1;
            
            answer[idx++] = rotate(x1,y1,x2,y2);
            
        }
        return answer;
    }
    
    private  int rotate(int x1, int y1, int x2, int y2){
        
        int tmp = arr[x1][y1];
        int min = tmp;
        
        // 왼쪽 : 위로 당기기
        for(int i = x1; i < x2; i++){
            arr[i][y1] = arr[i+1][y1];
            min = Math.min(min, arr[i][y1]);
        }
        
        // 아래쪽 : 왼쪽으로 당기기
        for(int j = y1; j < y2; j++){
            arr[x2][j] = arr[x2][j+1];
            min = Math.min(min, arr[x2][j]);
        }
        
        // 오른쪽 : 아래로 당기기
        for(int i = x2; i > x1; i--){
            arr[i][y2] = arr[i-1][y2];
            min = Math.min(min, arr[i][y2]);
        }
        
        // 위쪽 : 오른쪽으로 당기기
        for(int j = y2; j > y1; j--){
            arr[x1][j] = arr[x1][j-1];
            min = Math.min(min,arr[x1][j]);
        }
       
        arr[x1][y1+1] = tmp;
        
        return min;
    }
}