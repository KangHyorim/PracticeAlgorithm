import java.util.*;

class Solution {
    int maxCnt;
    Map<String, Integer> map; // 메뉴, 횟수
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        
        for(int c : course){
            map = new HashMap<>();
            maxCnt = 0;
            
            for(String order: orders){
                char[] charArr = order.toCharArray();
                Arrays.sort(charArr);
                
                // 정렬된 주문, 빈 조합, 시작 인덱스, 목표 길이
                findComb(new String(charArr), "", 0, c);
            }
            
            if(maxCnt >= 2){
                for(String key : map.keySet()){
                    if(map.get(key) == maxCnt){
                        answerList.add(key);
                    }
                }
            }
        }
        
        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }
    
    private void findComb(String order, String curr, int idx, int tarLen){
        if(curr.length() == tarLen){
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            maxCnt = Math.max(maxCnt, map.get(curr));
            return;
        }
        
        for(int i = idx; i < order.length(); i++){
            findComb(order, curr + order.charAt(i), i + 1, tarLen);
        }
    }
}