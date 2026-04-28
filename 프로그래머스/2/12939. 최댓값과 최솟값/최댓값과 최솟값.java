import java.util.*;

class Solution {
    public String solution(String s) {
        String[] parts = s.split(" ");
        int[] arr = new int[parts.length];
    
        for(int i = 0; i < parts.length; i++){
            arr[i] = Integer.parseInt(parts[i]);
        }
        
        String answer = "";
        Arrays.sort(arr);
        answer += arr[0];
        answer += " ";
        answer += arr[arr.length - 1];
        return answer;
    }
}