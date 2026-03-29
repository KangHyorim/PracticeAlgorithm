import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;

        // 1. 동생의 토핑 상태 초기화 (전체 개수와 종류 수)
        int[] brother = new int[10001];
        int brotherTypeCount = 0;
        for (int t : topping) {
            if (brother[t] == 0) brotherTypeCount++;
            brother[t]++;
        }

        // 2. 철수의 토핑 종류를 담을 Set
        Set<Integer> chulsu = new HashSet<>();

        // 3. 앞에서부터 하나씩 철수에게 넘기기
        for (int t : topping) {
            // 철수에게 추가
            chulsu.add(t);
            
            // 동생에게서 제거
            brother[t]--;
            if (brother[t] == 0) {
                brotherTypeCount--; // 해당 토핑이 동생에게 더 이상 없으면 종류 감소
            }

            // 4. 종류 수가 같아지는 지점 카운트
            if (chulsu.size() == brotherTypeCount) {
                answer++;
            }
        }

        return answer;
    }
}