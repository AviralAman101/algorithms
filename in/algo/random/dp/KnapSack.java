package in.algo.random.dp;

import java.util.Arrays;


/*
0 - 1 Knapsack Problem

You are given weights and values of N items, put these items in a
knapsack of capacity W to get the maximum total value in the knapsack.
Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1]
which represent values and weights associated with N items respectively.
Also given an integer W which represents knapsack capacity, find out the
maximum value subset of val[] such that sum of the weights of this subset is
smaller than or equal to W. You cannot break an item, either pick the complete
item or dont pick it (0-1 property).

Example 1:

Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3
Explanation: Choose the last item that weighs 1 unit and holds a value of 3.
Example 2:

Input:
N = 3
W = 3
values[] = {1,2,3}
weight[] = {4,5,6}
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Your Task:
Complete the function knapSack() which takes maximum capacity W, weight array wt[],
value array val[], and the number of items n as a parameter and returns
the maximum possible value you can get.

*/


public class KnapSack {

    public static void main(String[] args) {
        int value[] = new int[]{1,4,5,7};
        int weight[] = new int[]{1,3,4,5};
        int n=4, w=7;
        int[][] dp = new int[n+1][w+1];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
        int max = dfs(n,w,value,weight,dp);
        System.out.println(max);

        max = dfsWithoutDp(n,w,value,weight);
        System.out.println(max);

        max = bottomUp1D(n, w, value, weight);
        System.out.println(max);
    }

    private static int dfs(int n, int w, int[] value, int[] weight, int[][] dp) {
        if(n==0 || w==0) return 0;
        if(dp[n][w] != -1) return dp[n][w];

        int take=0;
        if(w>=weight[n-1]){
            take = value[n-1] + dfs(n-1, w-weight[n-1], value, weight,dp);
        }

        int notTake = dfs(n-1,w,value,weight,dp);
        dp[n][w] = Math.max(take, notTake);

        return dp[n][w];
    }

    private static int dfsWithoutDp(int n, int w, int[] value, int[] weight){
        if(n==0 || w==0) return 0;
        int take=0;
        if(w>=weight[n-1]){
            take = value[n-1] + dfsWithoutDp(n-1, w-weight[n-1], value, weight);
        }
        int notTake = dfsWithoutDp(n - 1, w, value, weight);
        return Math.max(take, notTake);
    }

    private static int bottomUp(int n, int w, int[] value, int[] weight){
        int[][] dp = new int[n+1][w+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i < w+1; i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= w ; j++) {
                int take=0;
                if(j-weight[i-1]>=0){
                    take = value[i-1] + (((j-weight[i-1]) > 0) ? dp[i-1][j-weight[i-1]] : 0);
                }
                int notTake = dp[i-1][j];
                dp[i][j] = Math.max(take, notTake);
            }
        }

        return dp[n][w];
    }

    private static int bottomUp1D(int n, int w, int[] value, int[] weight){
        int[] dp = new int[w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 7; j >= 0; j--) {
                if(j-weight[i]>=0){
                    dp[j] = Math.max(value[i] + dp[j-weight[i]],dp[j]);
                }
            }
        }
        return dp[w];
    }
}
