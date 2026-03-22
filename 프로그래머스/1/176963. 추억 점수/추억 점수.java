import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 1. 이름과 그리움 점수를 매핑
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];

        // 2. 각 사진별로 점수 계산
        for (int i = 0; i < photo.length; i++) {
            int currentScore = 0;
            for (String person : photo[i]) {
                // 이름이 맵에 존재할 때만 점수를 합산 (getOrDefault 활용)
                currentScore += scoreMap.getOrDefault(person, 0);
            }
            answer[i] = currentScore;
        }

        return answer;
    }
}