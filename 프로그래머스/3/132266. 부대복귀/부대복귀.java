import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        Arrays.fill(answer, -1);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] r : roads){
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        
            Queue<int[]> q = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            q.add(new int[]{destination, 0});
            visited[destination] = true;
            
            while(!q.isEmpty()){
                int[] curr = q.poll();
                for(int i = 0; i< sources.length; i++){
                    if(curr[0] == sources[i]){
                        answer[i] = curr[1];
                        break;
                    }
                }
                for(int node: graph.get(curr[0])){
                    if(!visited[node]){
                        q.add(new int[]{node, curr[1]+1});
                        visited[node] = true;
                    }
                }
            }
        return answer;
    }
}