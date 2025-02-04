import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] citations2 = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        
        Arrays.sort(citations2, Collections.reverseOrder());
        for(int i = 0 ; i<citations2.length; i++){
            if(i + 1 <= citations2[i]){
                answer = i+1;
            }
        }
        return answer;
    }
}