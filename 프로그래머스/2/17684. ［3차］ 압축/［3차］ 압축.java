import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        for(int i = 1; i <= 26; i++) {
            dict.put(String.valueOf((char)('A' + i - 1)), i);
        }
        
        int idx = 27;
        int cur = 0;    // 현재 문자열 시작 위치
        
        List<Integer> answer = new ArrayList<>();
        
        while(cur < msg.length()){
            String w = "";
            int nextCur = cur;
            
            while(nextCur + 1 <= msg.length()){
                String temp = msg.substring(cur, nextCur + 1);
                if(dict.containsKey(temp)){
                    w = temp;
                    nextCur++;
                }else{
                    break;
                }
            }
            
            answer.add(dict.get(w));
            cur = nextCur;
            
            if (nextCur < msg.length()) {
                String wc = w + msg.charAt(nextCur);
                dict.put(wc, idx++);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}