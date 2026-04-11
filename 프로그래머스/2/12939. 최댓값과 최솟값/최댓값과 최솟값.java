import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split(" ");  // ✅ String[]로 받기
        
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);  // ✅ int로 변환
        }
        
        Arrays.sort(arr);
        answer += arr[0];
        answer += " ";
        answer += arr[arr.length - 1];
        return answer;
    }
}