package in.algo.dynamicProgramming;


import java.util.Arrays;

/*
* Given an array `nums` consisting of positive numbers, your task is to partition the
* array into two separate arrays such that the absolute difference between their sums is minimized.

It is important to note that each element from the `nums` array must be
* present in one of the partitioned arrays.


For example, let's consider the following array: [2, 3, 1]

To achieve the minimum difference in the sums of the partitioned arrays,
* we can partition the array as follows:

Partition 1: [2, 1], Sum = 3

Partition 2: [3], Sum = 3

In this case, the minimum difference between the sums of the
* two partitions is calculated as |3 - 3| = 0.


Example 1: nums = [5, 4, 4, 7, 2, 9] Partitioned arrays: [4, 5, 7], [2, 4, 9] Minimum difference: 1

Example 2: nums = [3, 25, 4, 12, 2] Partitioned arrays: [25], [12, 4, 3, 2] Minimum difference: 4

Example 3: nums = [3, 7, 4, 12, 2] Partitioned arrays: [7, 4, 3], [12, 2] Minimum difference: 0
*
*
* */
public class MinimumSumPartition {
    public static void main(String[] args) {

        // dfs
        System.out.println(minDifferenceUsingDfs(-1,0,0,new int[]{5, 4, 4, 7, 2, 9}));
        // TopDown approach
        System.out.println(minDifferenceUsingTopDown(-1,0,0,new int[]{5, 4, 4, 7, 2, 9}));
        // BottomUp 1D approach
        System.out.println(minDifference1DBottomUp(new int[]{5, 4, 4, 7, 2, 9}));
    }
    private static int minDifference1DBottomUp(int[] nums){
        int sum = Arrays.stream(nums).sum();
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0]=true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >0; j--) {
                if(j-nums[i]>=0)
                dp[j] = j==nums[i] || dp[j-nums[i]];
            }
        }
        System.out.println(Arrays.toString(dp));
        for (int i = target; i >= 0; i--) {
            if(dp[i]) return Math.abs(sum-(2*i));
        }
        return -1;
    }




        private static int minDifferenceUsingTopDown(int index, long sum1, long sum2, int[] nums){
        long[][] dp = new long[nums.length][Arrays.stream(nums).sum() + 1];
        Arrays.stream(dp).forEach(ar -> Arrays.fill(ar, -1));
        return process(++index, sum1+nums[index], sum2, nums, dp);
    }
    private static int process(int index, long sum1, long sum2, int[] nums, long[][] dp) {
        if(index == nums.length-1) return (int)Math.abs(sum1-sum2);
        if(dp[index][(int)sum1] != -1) return (int)dp[index][(int)sum1];
        if(dp[index][(int)sum2] != -1) return (int)dp[index][(int)sum2];

        int left = process(++index, sum1+nums[index], sum2, nums, dp);
        int right = process(index, sum1, sum2+nums[index], nums, dp);
        dp[index][(int)sum1] = Math.min(left, right);
        dp[index][(int)sum2] = Math.min(left, right);
        return Math.min(left, right);
    }
    private static int minDifferenceUsingDfs(int index, long sum1, long sum2, int[] nums){
        if(index== nums.length-1)
            return (int) Math.abs(sum1-sum2);
        int left = minDifferenceUsingDfs(++index, sum1+nums[index], sum2, nums);
        int right = minDifferenceUsingDfs(index, sum1, sum2+nums[index], nums);
        return left>right ? right : left;
    }


}
