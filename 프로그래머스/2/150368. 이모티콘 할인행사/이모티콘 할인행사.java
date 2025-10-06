import java.util.*;

class Solution {
    int[] emoticons;
    int[][] users;
    int[] max = {-1, -1};
    float[] discount = {0.1f, 0.2f, 0.3f, 0.4f};
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        this.emoticons = emoticons;
        this.users = users;
        ArrayList<Float> dis = new ArrayList<>();
        dfs(dis, 0);
        
        return max;
    }
    
    public void dfs(ArrayList<Float> dis, int depth){
        if(depth == emoticons.length){
            int[] result = calc(dis);
            if(max[0] == result[0]){ //플러스 가입자 수가 같은면
                max[1] = Math.max(max[1], result[1]); //매출액 많은걸로 갱신
            } else if(max[0] < result[0]){
                max[0] = result[0];
                max[1] = result[1];
            }
            return;
        }
        
        for(int i = 0; i<discount.length; i++){
            dis.add(discount[i]);
            dfs(dis, depth+1);
            dis.remove(dis.size()-1); //백트래킹
        }
        
    }
    
    public int[] calc(ArrayList<Float> dis){
        int amount = 0;
        int cnt = 0;
        for(int[] u: users){
            int sum = 0;
            for(int i = 0; i<dis.size(); i++){
                if(u[0] <= dis.get(i) * 100){
                    sum += emoticons[i] * (1-dis.get(i));
                }
            }
            if(sum >= u[1]){
                cnt++;
                continue;
            }
            amount += sum;
        }
        return new int[]{cnt, amount};
        
    }
}