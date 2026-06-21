import java.util.*;

class Solution {
    public int[] solution(String s) {

        int[] answer = new int[s.length()];
        int[] last = new int[26];

        Arrays.fill(last, -1);

        for(int i = 0; i < s.length(); i++) {

            int idx = s.charAt(i) - 'a';

            if(last[idx] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - last[idx];
            }

            last[idx] = i;
        }

        return answer;
    }
}