class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 1. 모든 시간을 초 단위로 변환
        int videoTime = timeToSec(video_len);
        int currentTime = timeToSec(pos);
        int opStartTime = timeToSec(op_start);
        int opEndTime = timeToSec(op_end);

        // 2. 명령어 수행 루프
        for (String cmd : commands) {
            // 명령 수행 전 오프닝 체크
            currentTime = checkOpening(currentTime, opStartTime, opEndTime);

            if (cmd.equals("prev")) {
                currentTime = Math.max(0, currentTime - 10);
            } else if (cmd.equals("next")) {
                currentTime = Math.min(videoTime, currentTime + 10);
            }
            
            // 명령 수행 후 오프닝 체크
            currentTime = checkOpening(currentTime, opStartTime, opEndTime);
        }

        // 3. 다시 mm:ss 형식으로 변환하여 반환
        return secToTime(currentTime);
    }

    // 시간을 초로 변환하는 헬퍼 메서드
    private int timeToSec(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    // 초를 mm:ss 문자열로 변환
    private String secToTime(int seconds) {
        int m = seconds / 60;
        int s = seconds % 60;
        return String.format("%02d:%02d", m, s);
    }

    // 오프닝 구간인지 확인하고 건너뛰는 
    private int checkOpening(int current, int start, int end) {
        if (current >= start && current <= end) {
            return end;
        }
        return current;
    }
}