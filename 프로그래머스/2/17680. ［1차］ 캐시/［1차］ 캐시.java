import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        int time = 0;
        LinkedList<String> cache = new LinkedList<>();
        
        for(String city : cities){
            String s = city.toUpperCase();
            
            if(cache.remove(s)){
                cache.addLast(s);
                time += 1;
            }else{
                if (cache.size() >= cacheSize) {
                    cache.removeFirst(); 
                }
                cache.addLast(s);
                time += 5;
            }
        }
        return time;
    }
}