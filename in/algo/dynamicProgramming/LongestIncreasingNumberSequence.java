package in.algo.dynamicProgramming;

import java.util.Arrays;

/*
* Given an integer array nums, return the length of the longest strictly increasing
subsequence.


Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1


Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
*
* */

public class LongestIncreasingNumberSequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

    private static int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i <= nums.length; i++) {
            for (int j = i-1; j > 0 ; j--) {
                if(nums[i-1]>nums[j-1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    if(max < dp[i]) max = dp[i];
                }
                else dp[i] = Math.max(dp[i], 1);
            }
        }
        return max;
    }
}
