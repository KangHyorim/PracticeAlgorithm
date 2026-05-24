class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            int count = 0;
            char cur = c;
            while (count < index) {
                cur = (char)((cur - 'a' + 1) % 26 + 'a');
                if (skip.indexOf(cur) == -1) count++;
            }
            answer.append(cur);
        }

        return answer.toString();
    }
}