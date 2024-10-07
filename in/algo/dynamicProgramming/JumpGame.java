package in.algo.dynamicProgramming;


import java.util.Arrays;

/*
*
* You are given a 0-indexed array of integers nums of length n.
* You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward
* jump from index i. In other words, if you are at nums[i],
* you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1].
* The test cases are generated such that you can reach nums[n - 1].



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
* Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
*
* */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{3,2,1}));
    }

    private static int jump(int[] nums) {
        int length = nums.length;
        int dp[] = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = i;
        }
        // 2 3 1 1 4
        // 0 1 2 3 4
        for (int i = 0; i < length; i++) {
            int jump = nums[i];
            if (i + jump >= length)
                jump = length - i - 1;
            int minJump = Math.min(dp[i + jump], dp[i] + 1);
            dp[i + jump] = minJump;
            for (int j = i; j < i+jump; j++) {
                dp[j] = Math.min(dp[j], minJump);
            }

        }
        System.out.println(Arrays.toString(dp));
        return dp[length - 1];
    }
}
