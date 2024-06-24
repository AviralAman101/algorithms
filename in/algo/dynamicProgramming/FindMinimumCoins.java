package in.algo.dynamicProgramming;


import java.util.Arrays;

/*
*
*  You are given an integer array called coins, representing coins of different denominations,
* and an integer amount, representing a total amount of money. Your task is to find the
* fewest number of coins needed to make up that amount. If it is not possible to make
* up the amount using any combination of the coins, return -1.



Example 1: Input: coins = [1, 2, 5], amount = 11

Output: 3

Explanation: In this case, the minimum number of coins required to make up 11 is 3.
* One possible combination is 5 + 5 + 1.



Example 2: Input: coins = [2], amount = 3

Output: -1

Explanation: Here, it is not possible to make up the amount of 3 using the available
* coin with a denomination of 2. Hence, the output is -1.



Example 3: Input: coins = [1], amount = 0

Output: 0 Explanation: When the amount is 0, no coins are needed to make up the amount.
* Therefore, the output is 0.



Your goal is to find the fewest number of coins required to make up the given amount of money,
*  using the available denominations in the coins array.
*
* */
public class FindMinimumCoins {
    public static void main(String[] args) {
        System.out.println(minimumCoins(new int[]{1}, 0));
    }

    private static int minimumCoins(int[] coins, int amount){
        if(amount == 0) return -1;
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if(j-coins[i]>=0 && dp[j-coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
