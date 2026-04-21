import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        String[] arr = numbers.split("");
        visited = new boolean[arr.length];
        dfs("", arr);
        
        int answer = 0;
        for(int num : set){
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(int n){
        if(n < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    
    private void dfs(String current, String[] arr){
        if(!current.equals("")){
            set.add(Integer.parseInt(current));
        }
        
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(current+arr[i], arr);
                visited[i] = false;
            }
        }
    }
}