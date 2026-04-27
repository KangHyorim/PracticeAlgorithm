import java.util.*;

class Solution {
    String[] want;
    int[] number;
    String[] discount;
    int[] has;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        this.want = want;
        this.number = number;
        this.discount = discount;
        
        has = new int[number.length];
        for(int i = 0; i < 10; i++){
            int idx = matchItem(discount[i]);
            if (idx != -1) has[idx]++;
        }
        
        if (isPossible()) answer++;
        
        for(int i = 10; i < discount.length; i++){            
            int addIdx = matchItem(discount[i]);
            int removeIdx = matchItem(discount[i-10]);

            if (addIdx != -1) has[addIdx]++;       
            if (removeIdx != -1) has[removeIdx]--;
            
            if(isPossible()) answer++;
        }
        
        return answer;
    }
    
    private boolean isPossible() {
            for (int i = 0; i < want.length; i++) {
                if (has[i] < number[i]) return false;
            }
            return true;
    }
    
    private int matchItem(String item){
        for(int i = 0; i < want.length; i++){
            if(item.equals(want[i])) return i;
        }
        return -1;
    }
}