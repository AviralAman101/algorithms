package in.algo.dynamicProgramming;


import java.util.Arrays;

/*
* You are given a set of positive numbers called `nums` and a target sum value
* called `targetSum`.
* Your task is to count the total number of subsets within the given set whose
* sum equals the targetSum.

For example, let's consider the set {1, 2, 3, 4} and the target sum of 4.
* In this case, there are two subsets that add up to the target sum:

1. {1, 3}

2. {4}

Thus, the output for this example would be 2, as there are two subsets that
* fulfill the criteria of having a sum equal to the target sum.



Example 1: Input: nums = {1, 2, 3, 4} targetSum = 4

Output: 2

Explanation: There are two subsets that add up to the target sum of 4: {1, 3} and {4}.


Example 2: Input: nums = {1, 2, 7, 4, 5} targetSum = 9

Output: 2

Explanation: There are two subsets that add up to the target sum of 9: {2, 7} and {4, 5}.


Example 3: Input: nums = {1, 2, 3, 7} targetSum = 6

Output: 1

Explanation: There is one subset that adds up to the target sum of 6: {1, 2, 3}.
* */
public class SubsetSum {
    public static void main(String[] args) {
        // Param 1 has to be sorted array
        System.out.println(perfectSum2D(new int[]{1, 2, 3, 4},4,4));
    }

    // Using dp 1D bottom up approach
    private static int perfectSum(int[] arr, int n, int sum){
        int[] dp = new int[sum + 1];
        dp[0]=1;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if(j-arr[i]>=0){
                    dp[j] = dp[j]+dp[j-arr[i]];
                }
            }
        }
        return dp[sum];
    }

    private static int perfectSum2D(int[] arr, int n, int sum){
        int[][] dp = baseCase(arr, n, sum);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                int take=0;
                if(j-arr[i]>=0){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = take + dp[i-1][j];
            }
        }
        return dp[n-1][sum];
    }

    private static int[][] baseCase(int arr[], int n, int sum){
        int[][] dp = new int[n][sum + 1];
        Arrays.sort(arr);
        if(arr[0]==0){
            dp[0][0]=2;
        }else {
            dp[0][0] = 1;
            if(arr[0]<sum)
                dp[0][arr[0]]=1;
        }
        return dp;
    }
}
