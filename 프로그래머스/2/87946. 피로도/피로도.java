class Solution {
    int[][] dungeons;
    boolean[] visited;
    int max =-1;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        this.dungeons = dungeons;
        dfs(0, k);
        return max;
    }
    public void dfs(int depth, int k){
        for(int i = 0; i<dungeons.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(dungeons[i][0] <= k){
                    dfs(depth+1, k-dungeons[i][1]);
                }
                visited[i]=false;
                
            }
        }
        max = Math.max(depth, max);
    }
}