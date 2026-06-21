class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        
        for(int i = 0; i <= t.length() - len; i++){
            String str = t.substring(i, i + len);
            
            if(str.compareTo(p) <= 0) answer++;
        }
        
        return answer;
    }
}