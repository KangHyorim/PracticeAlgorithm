class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 1;
        
        // 탐색의 상한선을 찾기 위해 가장 높은 난이도를 구함
        for (int diff : diffs) {
            right = Math.max(right, diff);
        }
        
        int answer = right;
        
        // 이분 탐색 시작
        while (left <= right) {
            int mid = left + (right - left) / 2; // 현재 테스트할 숙련도
            
            if (isPossible(diffs, times, limit, mid)) {
                answer = mid;       // 제한 시간 내에 해결 가능하면 정답 후보로 저장
                right = mid - 1;    // 더 낮은 숙련도로도 가능한지 탐색 범위 축소
            } else {
                left = mid + 1;     // 해결 불가능하면 숙련도를 높여야 함
            }
        }
        
        return answer;
    }
    
    // 특정 숙련도(level)로 모든 퍼즐을 limit 시간 내에 풀 수 있는지 검증하는 메서드
    private boolean isPossible(int[] diffs, int[] times, long limit, int level) {
        // 첫 번째 퍼즐은 난이도가 무조건 1이므로 실패하지 않음
        long totalTime = times[0]; 
        
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                // 숙련도가 충분할 때
                totalTime += times[i];
            } else {
                // 숙련도가 부족하여 실패할 때
                int fails = diffs[i] - level;
                long failTime = (long) fails * (times[i] + times[i - 1]) + times[i];
                totalTime += failTime;
            }
            
            // 가지치기(Pruning): 계산 도중 이미 누적 시간이 limit을 초과했다면 즉시 실패 반환
            if (totalTime > limit) {
                return false;
            }
        }
        
        return true;
    }
}