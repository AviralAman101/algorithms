package in.algo.dynamicProgramming;


/*
*
* Given an array of positive integers arr. Find the maximum sum subsequence of the given array such that the integers in the subsequence are sorted in strictly increasing order i.e. a strictly increasing subsequence.

Examples:

Input: arr[] = [1, 101, 2, 3, 100]
Output: 106
Explanation: The maximum sum of a increasing sequence is obtained from [1, 2, 3, 100].
Input: arr[] = [4, 1, 2, 3]
Output: 6
Explanation: The maximum sum of a increasing sequence is obtained from {1, 2, 3}.
Input: arr[] = [4, 1, 2, 4]
Output: 7
Explanation: The maximum sum of a increasing sequence is obtained from {1, 2, 4}.
Constraints:
1  ≤  arr.size()  ≤  103
1  ≤  arr[i]  ≤  105
*
* */

public class MaxSumIncreasingNumber {
    public static void main(String[] args) {
        System.out.println(maxSumIS(new int[]{1, 101, 2, 3, 100}));
        System.out.println(maxSumIS(new int[]{4, 1, 2, 4}));
        System.out.println(maxSumIS(new int[]{4, 1, 2, 3}));
    }

    private static int maxSumIS(int arr[]) {
        // code here.
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i]=arr[i];
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+arr[i]);
                    if(max < dp[i]) max = dp[i];
                }
            }
        }

        return max;
    }
}
