import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {

        Arrays.sort(mats); // 오름차순 정렬

        for (int m = mats.length - 1; m >= 0; m--) {
            int size = mats[m];
            if (canPlace(size, park)) return size;
        }

        return -1;
    }

    private boolean canPlace(int k, String[][] park) {
        int n = park.length;
        int m = park[0].length;

        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {

                boolean ok = true;

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        if (!park[x][y].equals("-1")) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) break;
                }

                if (ok) return true;
            }
        }

        return false;
    }
}
