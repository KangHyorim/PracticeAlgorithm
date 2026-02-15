class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int limit = toMinute(schedules[i]) + 10;
            boolean ok = true;

            for (int j = 0; j < 7; j++) {

                int day = (startday + j - 1) % 7 + 1;
                if (day == 6 || day == 7) continue; // 토, 일 제외

                int arrive = toMinute(timelogs[i][j]);
                if (arrive > limit) {
                    ok = false;
                    break;
                }
            }

            if (ok) answer++;
        }

        return answer;
    }

    private int toMinute(int time) {
        return (time / 100) * 60 + (time % 100);
    }
}
