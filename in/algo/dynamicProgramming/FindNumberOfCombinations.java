package in.algo.dynamicProgramming;

/*
* You are given an integer array `coins`, representing coins of different denominations,
* and an integer `amount`, representing a total amount of money.
* Your task is to find the number of combinations of coins that can be used
* to make up that amount. If it is not possible to make up the amount using any
* combination of the coins, return 0.



Example 1:

Input: amount = 5, coins = [1, 2, 5]

Output: 4

Explanation: There are four ways to make up the amount 5:

- 5 = 5

- 5 = 2 + 2 + 1

- 5 = 2 + 1 + 1 + 1

- 5 = 1 + 1 + 1 + 1 + 1


Example 2:

Input: amount = 3, coins = [2]

Output: 0

Explanation: The amount of 3 cannot be made up using only coins of denomination 2, so the output is 0.



Example 3:

Input: amount = 10, coins = [10]

Output: 1

Explanation: The only way to make up the amount 10 is by using a single coin of denomination 10.



Your goal is to determine the number of combinations of coins that can be
* used to make up the given amount of money, using the available
* denominations in the `coins` array.
*
* */

import java.util.Arrays;

public class FindNumberOfCombinations {
    public static void main(String[] args) {
        System.out.println(findCombinationUsing_1DBottomUp(6, new int[]{1, 2, 5}));
        System.out.println(findCombinationUsing_1DBottomUp(3, new int[]{2}));
    }

    private static int findCombination(int n, int[] coins){

        int[][] dp = new int[coins.length+1][n+1];
        Arrays.stream(dp).forEach(ar -> Arrays.fill(ar, -1));
        return findCombinationUsing_DFS(n, coins,0, dp, 0);
    }

    private static int findCombinationUsing_DFS(int n, int[] coins, int index, int[][] dp, int sum) {
        if(n==sum) return 1;
        if(n< sum || index>=coins.length) return 0;
        int take = 0;
        if(dp[index][sum] != -1) return dp[index][sum];
        if(sum+coins[index] <= n)
         take = findCombinationUsing_DFS(n, coins, index, dp, sum+coins[index]);
        else take = findCombinationUsing_DFS(n, coins, index+1, dp, sum+coins[index]);
        int notTake = findCombinationUsing_DFS(n, coins, index+1, dp, sum);
        dp[index][sum] = take+notTake;
        return take+notTake;
    }

    private static int findCombinationUsing_1DBottomUp(int n, int coins[]){
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0]=1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                if(j-coins[i]>=0 && dp[j-coins[i]] != -1){
                    dp[j] = Math.max(dp[j-coins[i]], 0)+Math.max(0, dp[j]);
                }
            }
        }

        return dp[n] ==-1 ? 0 : dp[n];
    }
}
