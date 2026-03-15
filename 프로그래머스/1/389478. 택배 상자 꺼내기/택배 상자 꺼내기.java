class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int height = (n - 1) / w + 1;
        
        int targetRow = -1;
        int targetCol = -1;
        
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < w; c++) {
                int currentNum = 0;
                if (r % 2 == 0) {
                    currentNum = r * w + c + 1;
                } else {
                    currentNum = r * w + (w - 1 - c) + 1;
                }
                
                if (currentNum == num) {
                    targetRow = r;
                    targetCol = c;
                    break;
                }
            }
            if (targetRow != -1) break;
        }

        for (int r = targetRow; r < height; r++) {
            int currentNum = 0;
            if (r % 2 == 0) {
                currentNum = r * w + targetCol + 1;
            } else {
                currentNum = r * w + (w - 1 - targetCol) + 1;
            }
            
            if (currentNum <= n) {
                answer++;
            }
        }

        return answer;
    }
}