import java.util.*;

class Solution {
    int maxSheep = 0;
    int[] info;
    int[][] children;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        children = new int[info.length][2];
        
        for(int i = 0; i < info.length; i++) Arrays.fill(children[i], -1);
        
        for(int[] edge : edges){
            int parent = edge[0];
            int child = edge[1];
            if(children[parent][0] == -1) children[parent][0] = child;
            else children[parent][1] = child;
        }
        
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        
        dfs(0,0,0,nextNodes);
        
        return maxSheep;
    }
    
    private void dfs(int currIdx, int sheep, int wolf, List<Integer> nextNodes){
        if(info[currIdx] == 0) sheep++;
        else wolf++;
        
        if(wolf >= sheep) return;
        maxSheep = Math.max(maxSheep, sheep);
        List<Integer> candidates = new ArrayList<>(nextNodes);
        candidates.remove(Integer.valueOf(currIdx));
        
        if (children[currIdx][0] != -1) candidates.add(children[currIdx][0]);
        if (children[currIdx][1] != -1) candidates.add(children[currIdx][1]);

        for (int next : candidates) {
            dfs(next, sheep, wolf, candidates);
        }
    }
}