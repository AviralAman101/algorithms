package in.algo.dynamicProgramming;


import java.util.Arrays;

/*
 You are faced with a staircase that has `n` steps, and you want to reach the top.
 However, you can only climb either 1 or 2 steps at a time.
 Your task is to determine the number of distinct ways you can climb to the top.



Example 1:

Input: n = 2

Output: 2

Explanation: There are two ways to climb to the top:

1. Take 1 step + 1 step.

2. Take 2 steps.



Example 2:

Input: n = 3

Output: 3

Explanation: There are three ways to climb to the top:

1. Take 1 step + 1 step + 1 step.

2. Take 1 step + 2 steps.

3. Take 2 steps + 1 step.



You are given the number of steps `n`, your goal is to determine
the number of distinct ways you can climb to the top of the staircase
by taking either 1 or 2 steps at a time.

*/
public class NumberOfWaysOfClimbingStairs {

    public static void main(String[] args) {
        System.out.println(distinctWaysUsingDfs(3, 0));
        System.out.println(distinctWaysUsingDfs(2, 0));
        System.out.println(distinctWaysUsingDfs(4, 0));
        System.out.println(distinctWays(3));
        System.out.println(distinctWays(2));
        System.out.println(distinctWays(4));
    }

    //Bottom Up 1D
    private static int distinctWays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1, n + 1, -1);
        dp[0] = 1;

        for (int j = 1; j <= n; j++) {
            if (j - 1 >= 0 && dp[j - 1] != -1) {
                dp[j] = Math.max(dp[j], 0) + dp[j - 1];
            }
            if (j - 2 >= 0 && dp[j - 2] != -1) {
                dp[j] = Math.max(0, dp[j]) + dp[j - 2];
            }
        }

        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    //using DFS
    private static int distinctWaysUsingDfs(int n, int s) {
        if (n < s) return 0;
        if (n == s) return 1;
        return distinctWaysUsingDfs(n, s + 1) + distinctWaysUsingDfs(n, s + 2);
    }
}
