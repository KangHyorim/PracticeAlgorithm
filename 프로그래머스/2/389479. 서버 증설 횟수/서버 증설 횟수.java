import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        List<Integer> server = new ArrayList<>();
        
        for(int i = 0; i < players.length; i++){
            int time = i;
            server.removeIf(endTime -> endTime == time);
            
            int p = players[i];
            int capacity = (server.size() + 1) * m - 1;
            
            while(p > capacity) {
                server.add(i + k);
                answer++;
                
                capacity += m;
            }
        }
    
        return answer;
    }
}