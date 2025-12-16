import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int t: tangerine){
            hm.put(t, hm.getOrDefault(t, 0) + 1);
        }
        
        ArrayList<Integer> counts = new ArrayList<>(hm.values());
        counts.sort(Collections.reverseOrder());
        
        for(int c: counts){
            if(k>0){
                k -= c;
                answer++;
            }
        }
        
        return answer;
    }
}