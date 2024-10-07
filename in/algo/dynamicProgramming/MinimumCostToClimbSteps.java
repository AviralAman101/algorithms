package in.algo.dynamicProgramming;


/*
*
* You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
* Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.



Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.


Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999
*
* */
public class MinimumCostToClimbSteps {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }


    private static int minCostClimbingStairs(int[] cost) {

        // Solution 1
//        int dp[] = new int[cost.length+1];
//        Arrays.fill(dp, -1);
//        return dfs(-1, cost, dp);

        // Solution 2
        return dpUsingBottomUp(cost);
    }

    private static int dpUsingBottomUp(int[] cost) {
        if (cost.length < 2) return 0;
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(cost[i] + dp[i - 1], cost[i] + dp[i - 2]);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    private static int dfs(int index, int[] cost, int dp[]) {
        if (index == cost.length - 1) return 0;
        if (dp[index + 1] != -1) return dp[index + 1];
        int stepOne = 0;
        int stepTwo = 0;
        if (index + 1 < cost.length)
            stepOne = cost[index + 1] + dfs(index + 1, cost, dp);
        if (index + 2 < cost.length)
            stepTwo = cost[index + 2] + dfs(index + 2, cost, dp);

        return dp[index + 1] = Math.min(stepOne, stepTwo);
    }

}
