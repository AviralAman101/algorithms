package in.algo.dynamicProgramming;

import java.util.Arrays;

/*
* Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.



Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.


Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106
The answer is guaranteed to fit inside a 32-bit integer.
* */
public class NumberOfLongestIncreasingSequence {
    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{2,2,2,2,2}));
        System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));
    }
    private static int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        int max = -1;
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            for (int j = 1; j < i; j++) {
                if(nums[j-1] < nums[i-1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if(max < dp[i]){
                        count = 1;
                        max = dp[i];
                    } else if(max == dp[i]) count++;
                } else {
                    dp[i] = Math.max(1, dp[i]);
                    if(max < dp[i]){
                        count = 1;
                        max = dp[i];
                    } else if(max == dp[i]) count++;
                }
            }
        }
        return count-1;
    }
}
