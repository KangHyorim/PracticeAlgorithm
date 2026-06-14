import java.util.*;

class Solution {

    static class Group {
        int dia;
        int iron;
        int stone;

        Group(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }

    public int solution(int[] picks, String[] minerals) {

        int totalPick = picks[0] + picks[1] + picks[2];
        int maxMineral = Math.min(minerals.length, totalPick * 5);

        List<Group> groups = new ArrayList<>();

        for (int i = 0; i < maxMineral; i += 5) {

            int dia = 0;
            int iron = 0;
            int stone = 0;

            for (int j = i; j < Math.min(i + 5, maxMineral); j++) {

                String m = minerals[j];

                if (m.equals("diamond")) {
                    dia += 1;
                    iron += 5;
                    stone += 25;
                }
                else if (m.equals("iron")) {
                    dia += 1;
                    iron += 1;
                    stone += 5;
                }
                else {
                    dia += 1;
                    iron += 1;
                    stone += 1;
                }
            }

            groups.add(new Group(dia, iron, stone));
        }

        groups.sort((a, b) -> b.stone - a.stone);

        int answer = 0;
        int idx = 0;

        for (Group g : groups) {

            if (picks[0] > 0) {
                answer += g.dia;
                picks[0]--;
            }
            else if (picks[1] > 0) {
                answer += g.iron;
                picks[1]--;
            }
            else {
                answer += g.stone;
                picks[2]--;
            }
        }

        return answer;
    }
}