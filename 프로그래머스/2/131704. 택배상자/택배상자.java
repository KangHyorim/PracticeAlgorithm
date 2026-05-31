import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        
        Stack<Integer> sub = new Stack<>(); // 보조 컨테이너 벨트
        int belt = 1;        // 메인 벨트에서 꺼낼 다음 상자 번호
        int orderIdx = 0;    // 트럭에 실어야 할 순서 인덱스
        
        while (orderIdx < n) {
            int need = order[orderIdx]; // 지금 트럭에 실어야 할 상자
            
            if (!sub.isEmpty() && sub.peek() == need) {
                // 보조 벨트 맨 위가 필요한 상자면 바로 실음
                sub.pop();
                answer++;
                orderIdx++;
            } else if (belt <= n) {
                // 메인 벨트에서 상자를 보조 벨트로 이동
                sub.push(belt++);
            } else {
                // 메인 벨트도 비었고 보조 벨트 top도 아님 → 종료
                break;
            }
        }
        
        return answer;
    }
}