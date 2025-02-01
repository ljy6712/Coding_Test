import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    static boolean[] visited = new boolean[7];
    String numbers;
    public int solution(String numbers) {
        int answer = 0;
        this.numbers = numbers;
        dfs(0, "");
        
        for(Integer num: set){
            if(check(num)){
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int depth, String s){
        if(depth > numbers.length()){
            return;
        }
        for(int i = 0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(s+numbers.charAt(i)));
                dfs(depth+1, s+numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    public boolean check(int num){
        if(num<2){
            return false;
        }
        for(int i = 2; i<num;i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}