package in.algo.dynamicProgramming;


import java.util.Arrays;

/*
*
* Given an integer array of numbers,[1,3,4], and an integer n. Count all possible ways in which
* n can be expressed as a sum of given numbers. If there is no possible way to represent n using the provided
* numbers return 0.
*
* Ex -
* arr = [1,3,4]
* n = 4
* 1 + 1 + 1 + 1 = 4
* 1 + 3 = 4
* 3 + 1 = 4
* 4 = 4
* *
* */
public class CountNoOfSums {
    public static void main(String[] args) {
        System.out.println(countWaysUsingDFS(new int[]{1, 3, 4}, 4));
        System.out.println(countWaysUsingDFS(new int[]{1, 3, 4}, 3));
        System.out.println(countWaysUsingDFS(new int[]{1, 3, 4}, 5));
    }

    private static int countWaysUsingDFS(int arr[], int n) {
        //return dfs(arr, n, 0,0);
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return countWaysUsingBottomUp(arr, n, dp);
    }

    private static int dfs(int[] arr, int n, int index, int sum) {
        if (sum > n) return 0;
        if (index >= arr.length && sum != n) return 0;
        if (sum == n) return 1;
        return dfs(arr, n, index, sum + arr[index]) + dfs(arr, n, index + 1, sum);
    }

    private static int countWaysUsingBottomUp(int arr[], int n, int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        int take = 0;
        for (int j = 0; j < arr.length; j++) {
            if(n - arr[j] >= 0){
                take += countWaysUsingBottomUp(arr, n-arr[j], dp);
            }
        }
        dp[n] = take;
        return take;
    }
}
