import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1sum = 0;
        long q2sum = 0;
        long total = 0;
        for(int i = 0; i<queue1.length; i++){
            total += queue1[i];
            total += queue2[i];
            q1sum += queue1[i];
            q1.add(queue1[i]);
            q2sum += queue2[i];
            q2.add(queue2[i]);
        }
        if(total % 2 != 0){
            return -1;
        }
        int cnt = 0;
        while(cnt < ((queue1.length + queue2.length)*2)){
            if(q1sum == total/2){
                return cnt;
            }
            if(q1sum > total/2){
                int a = q1.poll();
                q1sum -= a;
                q2.add(a);
                q2sum += a;
                cnt++;
            }
            else{
                int a = q2.poll();
                q2sum -= a;
                q1.add(a);
                q1sum += a;
                cnt++;
            }
        }
        return -1;
    }
}