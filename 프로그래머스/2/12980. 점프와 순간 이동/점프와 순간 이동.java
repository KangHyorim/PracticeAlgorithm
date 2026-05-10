import java.util.*;

public class Solution {
    public int solution(int n) {
        int energy = 0;

        // n이 0이 될 때까지 역순으로 계산
        while (n > 0) {
            if (n % 2 == 0) {
                // 짝수라면 순간이동의 역과정: 비용 0
                n /= 2;
            } else {
                // 홀수라면 1칸 점프의 역과정: 비용 1 추가
                n -= 1;
                energy++;
            }
        }

        return energy;
    }
}