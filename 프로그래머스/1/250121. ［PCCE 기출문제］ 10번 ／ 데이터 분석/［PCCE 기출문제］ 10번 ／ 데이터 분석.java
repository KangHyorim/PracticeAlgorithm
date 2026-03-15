import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> colMap = new HashMap<>();
        colMap.put("code", 0);
        colMap.put("date", 1);
        colMap.put("maximum", 2);
        colMap.put("remain", 3);

        int extIdx = colMap.get(ext);
        int sortIdx = colMap.get(sort_by);

        List<int[]> list = new ArrayList<>();
        for (int[] d : data) {
            if (d[extIdx] < val_ext) {
                list.add(d);
            }
        }

        Collections.sort(list, (a, b) -> a[sortIdx] - b[sortIdx]);

        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}