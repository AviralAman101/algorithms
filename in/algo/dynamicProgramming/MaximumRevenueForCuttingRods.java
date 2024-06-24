package in.algo.dynamicProgramming;


/*
* You are given a rod of length n meters, and you can cut the rod into
* smaller pieces to maximize the revenue obtained from selling those pieces.
* The revenue is determined based on the length of each piece.
* Your task is to determine the maximum revenue that can be earned by cutting up the rod.

Here's an example to illustrate the problem:

Example: Let's consider a rod of length 4 meters, and we have two lists:

lengths = [1, 3, 4] (defines the possible lengths of the pieces)

prices = [2, 7, 8] (defines the corresponding prices for each length)

To maximize the revenue, we can cut the rod into different combinations
*  and calculate the total revenue generated from selling the pieces:

Four pieces of length 1 meter: 2 + 2 + 2 + 2 = 8

One piece of length 1 meter and another piece of length 3 meters: 2 + 7 = 9

One single piece of length 4 meters: 8

Therefore, the maximum revenue that can be generated by cutting the
* rod and selling the pieces is 9, achieved by cutting the
* rod into two pieces, one of length 1 meter and the other of length 3 meters.



Example 1: Input: n = 4, lengths = [1, 2, 3, 4], prices = [2, 3, 7, 8]

Output: 9

Explanation: In this case, the maximum revenue can be achieved
* by cutting the rod into two pieces, one of length 1 meter and
* the other of length 3 meters. The revenue earned from selling
* these pieces would be 2 + 7 = 9.



Example 2: Input: n = 6, lengths = [1, 2, 3, 4, 5, 6], prices = [2, 5, 8, 9, 10, 11]

Output: 16

Explanation: Here, the maximum revenue can be obtained by cutting
* the rod into three pieces, with lengths 2, 2, and 2 meters.
* The revenue earned would be 5 + 5 + 6 = 16.



Example 3: Input: n = 5, lengths = [1, 2, 3, 4, 5], prices = [2, 6, 7, 10, 13]

Output: 14

Explanation: In this case, the rod can be cut into two pieces,
* one of length 2 meters and the other of length 3 meters.
* The revenue earned would be 6 + 8 = 14.



Your goal is to determine the maximum revenue that can be
* obtained by cutting the given rod of length n into smaller pieces,
* using the provided lengths and their corresponding prices.
*
* */

import java.util.Arrays;

public class MaximumRevenueForCuttingRods {
    public static void main(String[] args) {
        System.out.println(maximumRevenue(5, new int[]{1, 2, 3, 4, 5}, new int[]{2, 6, 7, 10, 13}));
        System.out.println(maximumRevenue(4, new int[]{1, 2, 3, 4}, new int[]{2, 3, 7, 8}));
        System.out.println(maximumRevenue(6, new int[]{1, 2, 3, 4, 5, 6}, new int[]{2,5,8, 9, 10, 11}));
    }

    private static int maximumRevenue(int n, int[] lengths, int[] revenues){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0]=0;

        for (int i = 0; i < lengths.length; i++) {
            for (int j = 1; j <= n; j++) {
                if(j-lengths[i]>=0 && dp[j-lengths[i]] != -1){
                    dp[j] = Math.max(dp[j], revenues[i]+dp[j-lengths[i]]);
                }
            }
        }

        return dp[n];
    }
}
