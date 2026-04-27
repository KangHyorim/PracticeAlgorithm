class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long min = 0;
        long max = (long) (1e15); 
        long answer = max;

        while (min <= max) {
            long mid = (min + max) / 2;
            
            long gold = 0;
            long silver = 0;
            long total = 0;
            
            for(int i = 0; i < g.length; i++){
                long cnt = mid / (t[i] * 2);
                if(mid % (t[i] * 2) >= t[i]) cnt++;
                
                long maxPayload = cnt * w[i];
                
                gold += Math.min(g[i], maxPayload);
                silver += Math.min(s[i], maxPayload);
                total += Math.min(g[i] + s[i], maxPayload);
            }
            
            if (gold >= a && silver >= b && total >= (a + b)) {
                answer = mid;
                max = mid - 1; 
            } else {
                min = mid + 1; 
            }
        }
        
        return answer;
    }
}