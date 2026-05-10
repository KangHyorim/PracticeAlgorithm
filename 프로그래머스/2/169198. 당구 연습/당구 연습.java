class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            int minDistance = Integer.MAX_VALUE;
            
            // 1. 왼쪽 벽 대칭 (-targetX, targetY)
            // 조건: 시작 공과 목표 공의 y가 같으면서 시작 공이 더 오른쪽에 있으면 안 됨 (가는 길에 목표 공이 있음)
            if (!(startY == targetY && startX > targetX)) {
                minDistance = Math.min(minDistance, getDistance(startX, startY, -targetX, targetY));
            }
            
            // 2. 오른쪽 벽 대칭 (2*m - targetX, targetY)
            // 조건: y가 같으면서 시작 공이 더 왼쪽에 있으면 안 됨
            if (!(startY == targetY && startX < targetX)) {
                minDistance = Math.min(minDistance, getDistance(startX, startY, 2 * m - targetX, targetY));
            }
            
            // 3. 아래쪽 벽 대칭 (targetX, -targetY)
            // 조건: x가 같으면서 시작 공이 더 위에 있으면 안 됨
            if (!(startX == targetX && startY > targetY)) {
                minDistance = Math.min(minDistance, getDistance(startX, startY, targetX, -targetY));
            }
            
            // 4. 위쪽 벽 대칭 (targetX, 2*n - targetY)
            // 조건: x가 같으면서 시작 공이 더 아래에 있으면 안 됨
            if (!(startX == targetX && startY < targetY)) {
                minDistance = Math.min(minDistance, getDistance(startX, startY, targetX, 2 * n - targetY));
            }
            
            answer[i] = minDistance;
        }
        
        return answer;
    }
    
    // 피타고라스 정리에 의한 거리의 제곱 구하기
    private int getDistance(int x1, int y1, int x2, int y2) {
        return (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}