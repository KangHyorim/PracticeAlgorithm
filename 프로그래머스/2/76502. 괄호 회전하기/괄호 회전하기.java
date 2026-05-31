import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        
        for (int x = 0; x < n; x++) {
            String rotated = s.substring(x) + s.substring(0, x);
            
            if (isValid(rotated)) answer++;
        }
        
        return answer;
    }
    
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (ch == ')' && top != '(') return false;
                if (ch == ']' && top != '[') return false;
                if (ch == '}' && top != '{') return false;
            }
        }
        
        return stack.isEmpty();
    }
}