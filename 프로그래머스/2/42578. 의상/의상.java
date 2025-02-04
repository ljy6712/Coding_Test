import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> h = new HashMap<>();
        for(int i = 0; i<clothes.length; i++){
            h.put(clothes[i][1], h.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int cnt = 1;
        for(Integer value: h.values()){
            cnt *= (value+1);
        }
        answer = cnt -1;
        return answer;
    }
}