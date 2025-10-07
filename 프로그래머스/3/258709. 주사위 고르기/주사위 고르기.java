import java.util.*;

class Solution {
    int n; // 전체 주사위 수
    int half; // A가 고를 개수
    int[][] dice;
    boolean[] visited;
    long bestWin = -1;
    int[] bestPick;

    public int[] solution(int[][] dice) {
        this.dice = dice;
        this.n = dice.length;
        this.half = n / 2;
        this.visited = new boolean[n];

        dfs(0, 0); // 인덱스, 선택 개수

        return bestPick;
    }

    void dfs(int idx, int cnt) {
        if (cnt == half) {
            evaluate();
            return;
        }
        if (idx == n) return;

        // idx번째 주사위 선택
        visited[idx] = true;
        dfs(idx + 1, cnt + 1);

        // 선택 취소
        visited[idx] = false;
        dfs(idx + 1, cnt);
    }

    void evaluate() {
        // 선택된 주사위(A), 선택 안 된 주사위(B)
        List<int[]> A = new ArrayList<>();
        List<int[]> B = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) A.add(dice[i]);
            else B.add(dice[i]);
        }

        long[] distA = buildDist(A);
        long[] distB = buildDist(B);

        // B 누적합
        for (int i = 1; i < distB.length; i++) {
            distB[i] += distB[i - 1];
        }

        long win = 0;
        for (int i = 1; i < distA.length; i++) {
            win += distA[i] * distB[i - 1];
        }

        if (win > bestWin) {
            bestWin = win;
            bestPick = new int[half];
            int p = 0;
            for (int i = 0; i < n; i++) if (visited[i]) bestPick[p++] = i + 1;
        }
    }

    long[] buildDist(List<int[]> list) {
        int maxSum = list.size() * 100;
        long[] dp = new long[maxSum + 1];
        dp[0] = 1;

        for (int[] die : list) {
            long[] next = new long[maxSum + 1];
            for (int i = 0; i <= maxSum; i++) {
                if (dp[i] == 0) continue;
                for (int face : die) {
                    next[i + face] += dp[i];
                }
            }
            dp = next;
        }
        return dp;
    }
}