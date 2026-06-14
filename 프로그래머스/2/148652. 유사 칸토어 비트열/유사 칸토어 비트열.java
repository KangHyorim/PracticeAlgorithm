class Solution {

    public int solution(int n, long l, long r) {
        return (int)(getOneCount(r, n) - getOneCount(l - 1, n));
    }

    private long getOneCount(long x, int n) {
        if (x <= 0) return 0;
        if (n == 0) return 1;

        long len = (long)Math.pow(5, n - 1);
        long ones = (long)Math.pow(4, n - 1);

        long section = x / len;
        long remain = x % len;

        // x가 딱 섹션 경계선에 걸쳐 떨어지는 경우를 위해 
        // 만약 remain이 0이라면 이전 섹션의 맨 끝으로 취급하는 것이 안전합니다.
        // 하지만 아래와 같이 section별로 깔끔하게 밀어버리는 유틸 구조가 더 직관적입니다.

        if (section < 2) {
            // 0, 1번 구역에 위치할 때: 앞선 구역들의 1의 개수 + 현재 구역 나머지 재귀
            return section * ones + getOneCount(remain, n - 1);
        } else if (section == 2) {
            // 2번 구역(가운데 0구역)에 걸쳐있을 때: 앞선 0, 1번 구역의 1만 전부 더하고 종료 (내부엔 1이 없음)
            return 2 * ones;
        } else {
            // 3, 4번 구역에 위치할 때: 2번 구역은 0구역이므로 1의 개수에서 제외해야 함.
            // 따라서 (section - 1) * ones를 해주고 현재 구역 나머지 재귀
            return (section - 1) * ones + getOneCount(remain, n - 1);
        }
    }
}