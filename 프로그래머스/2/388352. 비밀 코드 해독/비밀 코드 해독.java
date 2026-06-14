import java.util.*;

class Solution {
    
    int answer = 0;
    int n;
    int[][] q;
    int[] ans;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        comb(1, 0, new int[5]);
        
        return answer;
    }
    
    private void comb(int start, int depth, int[] secret) {
        if (depth == 5) {
            if (isValid(secret)) {
                answer++;
            }
            return;
        }
        
        for (int i = start; i <= n; i++) {
            secret[depth] = i;
            comb(i + 1, depth + 1, secret);
        }
    }
    
    private boolean isValid(int[] secret) {
        Set<Integer> secretSet = new HashSet<>();
        
        for (int num : secret) {
            secretSet.add(num);
        }
        
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            
            for (int num : q[i]) {
                if (secretSet.contains(num)) {
                    cnt++;
                }
            }
            
            if (cnt != ans[i]) {
                return false;
            }
        }
        
        return true;
    }
}