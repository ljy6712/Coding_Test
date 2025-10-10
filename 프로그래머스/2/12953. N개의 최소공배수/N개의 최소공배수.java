import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int a: arr){
        for(int i = 2; i <= a; i++) {
            int cnt = 0;
	        while(a % i == 0) {
		        cnt++;
		        a /= i;
	        }
            map.put(i, Math.max(map.getOrDefault(i, 0),cnt));
        }
        }
        
        for(Map.Entry<Integer, Integer> a : map.entrySet()){
            for(int i = 0; i<a.getValue(); i++){
                answer *= a.getKey();
            }
        }
        
        return answer;
    }
}