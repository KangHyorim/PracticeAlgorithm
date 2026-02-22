import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<int[]> moves;

    public int[][] solution(int n) {
        moves = new ArrayList<>();
        
        // n개의 원판을 1번 기둥에서 3번 기둥으로 옮김 (2번 기둥을 보조로 사용)
        hanoi(n, 1, 3, 2);
        
        // List를 2차원 배열로 변환하여 반환
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }
        return answer;
    }

    private void hanoi(int n, int start, int end, int mid) {
        // 기저 조건: 원판이 1개 남았을 때는 바로 목적지로 이동
        if (n == 1) {
            moves.add(new int[]{start, end});
            return;
        }
        
        // 1. 맨 밑의 가장 큰 원판을 제외한 n-1개의 원판을 시작 기둥에서 보조 기둥으로 이동
        hanoi(n - 1, start, mid, end);
        
        // 2. 가장 큰 원판을 시작 기둥에서 목적지 기둥으로 이동
        moves.add(new int[]{start, end});
        
        // 3. 보조 기둥에 옮겨두었던 n-1개의 원판을 목적지 기둥으로 이동
        hanoi(n - 1, mid, end, start);
    }
}