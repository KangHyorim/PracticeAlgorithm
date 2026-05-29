import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) return 0;
        
        boolean[] visited = new boolean[y + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});
        visited[x] = true; 
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currNum = current[0];
            int currCnt = current[1];
            
            int[] next = {currNum + n, currNum * 2, currNum * 3};
            
            for(int num : next){
                if(num == y) return currCnt + 1; 
                if(num < y && !visited[num]){    
                    visited[num] = true;
                    queue.add(new int[]{num, currCnt + 1});
                }
            }
        }
        
        return -1;
    }
}