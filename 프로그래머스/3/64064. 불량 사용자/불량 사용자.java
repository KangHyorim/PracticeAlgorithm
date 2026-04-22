import java.util.*;

class Solution {
    HashSet<HashSet<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, new HashSet<>(), user_id, banned_id);
        
        int answer = result.size();
        return answer;
    }
    
    void dfs(int index, HashSet<String> picked, String[] user_id, String[] banned_id){
        if(index == banned_id.length){
            result.add(new HashSet<>(picked));
            return;
        }
        
        // 현재 순서의 banned_id[index]랑 매칭되는 유저 찾기
        for(int i = 0; i < user_id.length; i++){
            if(!picked.contains(user_id[i]) && isMatch(user_id[i], banned_id[index])){
                picked.add(user_id[i]);
                dfs(index + 1, picked, user_id, banned_id);
                picked.remove(user_id[i]);
            }
        }
    }
    
    boolean isMatch(String user, String banned){
        if(user.length() != banned.length()) return false;
        
        for(int i = 0; i < user.length(); i++){
            if(banned.charAt(i) != '*' && user.charAt(i) != banned.charAt(i)) return false;
        }
        return true;
    }
}