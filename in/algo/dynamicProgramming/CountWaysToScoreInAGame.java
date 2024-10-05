package in.algo.dynamicProgramming;


import java.util.Arrays;
import java.util.List;

/*
*
* Suppose there is a game where a player can score 1, 2 or 4 in each turn.
* Given a total, n, find all possible ways in which you can score these n points.
*
* Note : you man assume that you can use a specific score as many times as you want.
* Additionally, the order in which we select a score is significant.
*
* Let's say the total points to be earned are 3. A player can score this total in the following ways.
*
* 1+1+1 = 3
* 1+2 = 3
* 2+1 = 3
*
* */
public class CountWaysToScoreInAGame {
    public static void main(String[] args) {
        //Driver code
        List<Integer> scoreValue = Arrays.asList(1, 2, 4);

        int n=3;
        //Method 1 : using DFS
        System.out.println(totalWaysToScoreUsingDFS(n, scoreValue));

        //Method 2: using dp
        int max = Math.max(n, scoreValue.stream().mapToInt(i -> i).max().getAsInt());
        long []dp = new long[max+1];
        Arrays.fill(dp, -1);
        dp[0]=1;
        System.out.println(totalWaysToScoreUsingDP(n, scoreValue, dp));
    }

    private static long totalWaysToScoreUsingDFS(int n, List<Integer> scoreValue){
        if(n == 0) return 1;
        if(n < 0) return 0;

        long sum = 0;
        for (int i = 0; i < scoreValue.size(); i++) {
            sum += totalWaysToScoreUsingDFS(n-scoreValue.get(i), scoreValue);
        }
        return sum;
    }

    private static long totalWaysToScoreUsingDP(int n, List<Integer> scoreValue, long[] dp){
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(dp[n] != -1) return dp[n];
        long sum = 0;
        for (int i = 0; i < scoreValue.size(); i++) {
            sum += totalWaysToScoreUsingDP(n-scoreValue.get(i), scoreValue, dp);
        }
        dp[n] = sum;
        return sum;
    }
}
