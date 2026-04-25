class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] cycles = new int[n];
        long limitLcm = 1;
        
        for(int i = 0; i < n; i++){
            cycles[i] = signals[i][0] + signals[i][1] + signals[i][2];
            limitLcm = lcm(limitLcm, cycles[i]);
        }
        
        for(int t = 1; t <= limitLcm; t++){
            boolean allYellow = true;
            
            for(int i = 0; i < n; i++){
                int g = signals[i][0];
                int y = signals[i][1];
                int cycle = cycles[i];
                
                int remain = (t-1) % cycle;
                
                if (!(remain >= g && remain < g + y)) {
                    allYellow = false;
                    break;
                }
            }
            if(allYellow) return t;
        }
        return -1;
    }
    
    private long gcd(long a, long b){
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    private long lcm(long a, long b){
        if(a == 0 || b == 0) return 0;
        return (a*b) / gcd(a,b);
    }
}