import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int i = 0;
        for(int num : answers){
            if(num1[i%5] == num){
                cnt1++;
            }
            if(num2[i%8] == num){
                cnt2++;
            }
            if(num3[i%10] == num){
                cnt3++;
            }
            i++;
        }
        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        List<Integer> result = new ArrayList<>();
        if(cnt1 == max) result.add(1);
        if(cnt2 == max)result.add(2);
        if(cnt3 == max)result.add(3);
        return result.stream().mapToInt(j -> j).toArray();
    }
}