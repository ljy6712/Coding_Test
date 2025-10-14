import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i<players.length; i++){
            while(!q.isEmpty() && q.peek() <= i){
                q.poll();
                cnt--;
            }
            while(cnt < players[i] / m){
                cnt++;
                q.add(i + k);
                answer++;
            }
        }
        return answer;
    }
}