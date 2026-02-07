import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] del = new int[24];
        
        int current = 0;
        
        for(int i = 0; i < players.length; i++){
            current -= del[i];
            
            int capacity = (current + 1) * m - 1;
            
            if(players[i] > capacity) {
                int needed = players[i] - capacity;
                
                int add = (needed + m - 1) / m;
                
                answer += add;
                current += add;
                
                if(i+k < 24){
                    del[i+k] += add;
                }
            }
        }
    
        return answer;
    }
}