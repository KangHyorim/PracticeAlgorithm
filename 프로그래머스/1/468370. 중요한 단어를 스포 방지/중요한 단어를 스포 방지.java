import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        boolean[] isSpoiler = new boolean[message.length()];
        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) isSpoiler[i] = true;
        }

        // 단어 목록 + 시작 인덱스 + 스포 여부
        List<Object[]> words = new ArrayList<>();
        int idx = 0;
        for (String word : message.split(" ", -1)) {
            boolean hasSpoiler = false;
            for (int i = 0; i < word.length(); i++) {
                if (isSpoiler[idx + i]) { hasSpoiler = true; break; }
            }
            words.add(new Object[]{word, idx, hasSpoiler});
            idx += word.length() + 1;
        }

        // 스포 구간 밖에 등장한 단어 집합
        Set<String> nonSpoilerWords = new HashSet<>();
        for (Object[] w : words) {
            if (!(boolean) w[2]) nonSpoilerWords.add((String) w[0]);
        }

        // 구간별 포함 스포 단어 수집 (첫 번째 겹치는 구간 기준)
        Map<Integer, List<String>> rangeToWords = new LinkedHashMap<>();
        for (int i = 0; i < spoiler_ranges.length; i++) rangeToWords.put(i, new ArrayList<>());

        for (Object[] w : words) {
            String word = (String) w[0];
            int wStart = (int) w[1];
            int wEnd = wStart + word.length() - 1;
            if (!(boolean) w[2]) continue;

            for (int i = 0; i < spoiler_ranges.length; i++) {
                if (wStart <= spoiler_ranges[i][1] && wEnd >= spoiler_ranges[i][0]) {
                    rangeToWords.get(i).add(word);
                    break;
                }
            }
        }

        // 구간 순서대로 공개하며 카운트
        int answer = 0;
        Set<String> revealed = new HashSet<>();
        for (int i = 0; i < spoiler_ranges.length; i++) {
            for (String word : rangeToWords.get(i)) {
                if (!nonSpoilerWords.contains(word) && !revealed.contains(word)) {
                    answer++;
                    revealed.add(word);
                }
            }
        }

        return answer;
    }
}