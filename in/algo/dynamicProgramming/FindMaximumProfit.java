package in.algo.dynamicProgramming;


/*
* Given a set of N items, each with a weight and a value,
* represented by arrays w[] and val[] respectively, as well as a knapsack
* with a weight limit W, the task is to fill the knapsack in a way that
* maximizes the total profit. The function should return the maximum profit achievable.



Example 1:

Input: N = 2, W = 3

val[] = {1, 1}

wt[] = {2, 1}

Output: 3

Explanation: In this case, the optimal strategy is to pick the 2nd item three times.
* The total profit achieved is 1 + 1 + 1 = 3. The total weight is 1 + 1 + 1 = 3,
* which is within the weight limit W.



Example 2:

Input: N = 4, W = 8

val[] = {1, 4, 5, 7}

wt[] = {1, 3, 4, 5}

Output: 11

Explanation: The optimal choice is to pick the 2nd and 4th items.
* The total profit achieved is 4 + 7 = 11.



Goal is to maximize the total profit by selecting items from the given set,
* while ensuring that the total weight of the selected items does not exceed
* the weight limit W. Note that each item can be taken any number of times.
*
* */
public class FindMaximumProfit {
    public static void main(String[] args) {
        System.out.println(findMaximumProfit(4,8,new int[]{1, 4, 5, 7}, new int[]{1, 3, 4, 5}));
    }

    private static int findMaximumProfit(int n, int w, int[] val, int[] weight){
        int dp[] = new int[w+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if(j >= weight[i]){
                    dp[j] = Math.max(dp[j], val[i]+dp[j-weight[i]]);
                }
            }
        }

        return dp[w];
    }
}
