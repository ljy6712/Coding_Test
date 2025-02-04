import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int answer = 0;
        for(int i = 0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        while(pq.peek() < K && pq.size() >1){
            int s = pq.peek();
            pq.remove();
            int d = pq.peek();
            pq.remove();
            pq.add(s + (d*2));
            answer++;
        }
        if(pq.peek() < K)
            return -1;
        return answer;
    }
}