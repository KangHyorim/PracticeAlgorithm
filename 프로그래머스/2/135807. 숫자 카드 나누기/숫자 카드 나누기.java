import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = getArrayGCD(arrayA);
        if(isNotDivisible(gcdA, arrayB)){
            answer = Math.max(answer, gcdA);
        }
        
        int gcdB = getArrayGCD(arrayB);
        if(isNotDivisible(gcdB, arrayA)){
            answer = Math.max(answer, gcdB);
        }
    
        
        return answer;
    }
    
    private boolean isNotDivisible(int num, int[] targetArray) {
        if (num == 1) return false; 
        for (int val : targetArray) {
            if (val % num == 0) return false;
        }
        return true;
    }
    
    private int getArrayGCD(int[] arr){
        int res = arr[0];
        for(int i = 1; i < arr.length; i++){
            res = gcd(res, arr[i]);
        }
        return res;
    }
    
    private int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}