import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 각 문자를 입력하는 데 필요한 최소 횟수 저장
        Map<Character, Integer> minPress = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                // 이미 저장된 값보다 더 적은 횟수면 갱신
                minPress.put(c, Math.min(minPress.getOrDefault(c, Integer.MAX_VALUE), i + 1));
            }
        }

        int[] answer = new int[targets.length];

        for (int t = 0; t < targets.length; t++) {
            int total = 0;
            boolean possible = true;

            for (char c : targets[t].toCharArray()) {
                if (!minPress.containsKey(c)) {
                    possible = false;
                    break;
                }
                total += minPress.get(c);
            }

            answer[t] = possible ? total : -1;
        }

        return answer;
    }
}