class Solution {
    public int solution(int n) {
        int targetCnt = Integer.bitCount(n);
        int nextNum = n+1;
        
        while(true){
            if(Integer.bitCount(nextNum) == targetCnt) return nextNum;
            nextNum++;
        }
    }
}