import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            q.add(new int[] {i, priorities[i]});
        }
        
        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int max = 0;
            for(int[] elem : q) max = Math.max(max, elem[1]);
            
            if(cur[1] < max) q.add(cur);
            else{
                cnt++;
                if(cur[0] == location) return cnt;
            }
        }
        
        return cnt;
    }
}