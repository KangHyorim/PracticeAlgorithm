import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 모든 간선들을 하나씩 끊어보기
        for(int i = 0; i < wires.length; i++){
            graph = new ArrayList[n+1];
            
            for(int j = 1; j <= n; j++){
                graph[j] = new ArrayList<>();
            }
            
            // 간선 연결하기
            for(int j = 0; j < wires.length; j++){
                if(i == j) continue;
                
                int v1 = wires[j][0];
                int v2 = wires[j][1];
                graph[v1].add(v2);
                graph[v2].add(v1);
            }
            
            // 1번 노드에서 BFS로 한쪽 그룹 노드 수 계산
            visited = new boolean[n+1];
            int cnt = bfs(1);
            
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    static int bfs(int start){
       Queue<Integer> queue = new LinkedList<>();
       queue.add(start);
        visited[start] = true;
       int cnt = 0;
       
       while(!queue.isEmpty()){
           int node = queue.poll();
           cnt++;
           
           for(int next : graph[node]){
               if(!visited[next]){
                   visited[next] = true;
                   queue.add(next);
               }
           }
       }
       return cnt;
   }
}