package in.algo.dynamicProgramming;

/*
*
* Given an array arr of size N, the task is to remove or delete the minimum number of elements from the array so that when the remaining elements are placed in the same sequence order form an increasing sorted sequence.

Example 1:

Input: N = 5, arr[] = {5, 6, 1, 7, 4}
Output: 2
Explanation: Removing 1 and 4
leaves the remaining sequence order as
5 6 7 which is a sorted sequence.

Example 2:
Input: N = 3, arr[] = {1, 1, 1}
Output: 2
Explanation: Remove 2 1's


Your Task:
You don't need to read input or print anything. Complete the function minDeletions() which takes N and array arr as input parameters and returns the integer value

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 103
*
* */
public class MinimumDeletionsToSortArray {
    public static void main(String[] args) {
        System.out.println(minDeletions(new int[]{5, 6, 1, 7, 4}, 5));
        System.out.println(minDeletions(new int[]{1, 1, 1}, 3));
        System.out.println(minDeletions(new int[]{50 ,47, 25, 47, 45, 50, 8, 32}, 8));
    }

    private static int minDeletions(int arr[], int n)
    {
        int dp[] = new int[n+1];
        dp[0] = 1;

        int max = 1;
        for (int i = 1; i < n ; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if(max < dp[i]) max = dp[i];
                }else dp[i] = Math.max(1, dp[i]);

            }
        }
        return n-max;
    }
}
