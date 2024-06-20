package in.algo.dynamicProgramming;

/*
* You have been given an array of integers called nums and an integer called target.
* Your task is to create an expression by adding either a '+' or '-' symbol
* before each integer in nums, and then concatenate all the integers together.
* This expression should evaluate to the target value.

For instance, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1,
* resulting in the expression "+2-1". Your goal is to determine the number of
* different expressions you can create that evaluate to the target value.



Here are a couple of examples to illustrate the problem:

Example 1:

Input: nums = [1, 1, 1, 1, 1], target = 3

Output: 5

Explanation: There are five different ways to assign symbols to the integers in
* nums in order to obtain a sum of 3:
*
* -1 + 1 + 1 + 1 + 1 = 3
* +1 - 1 + 1 + 1 + 1 = 3
* +1 + 1 - 1 + 1 + 1 = 3
* +1 + 1 + 1 - 1 + 1 = 3
* +1 + 1 + 1 + 1 - 1 = 3

Example 2:

Input: nums = [1], target = 1

Output: 1

Explanation: In this case, you have an array with a single integer, and the target value is also 1.
* There is only one way to form an expression, which is by using the number as is (without any symbols): 1.
*
* */

import java.util.Arrays;

public class FindTargetSum {
    public static void main(String[] args) {
        System.out.println(findTargetSum(new int[]{1, 1, 1, 1}, 2));
        System.out.println(findTargetSum(new int[]{0}, 0));
    }

    private static int findTargetSum(int[] nums, int target){
        int[][] dp = new int[nums.length][(nums.length*2)+1];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr,-1));
        return targetSumUsingBottomUpDP(nums, target);
    }

    private static int dpTopDown(int[] nums, int target, int index, int sum, int[][] dp) {
        if(index== nums.length){
            if(sum==target) return 1;
            return 0;
        }

        if(dp[index][sum+ nums.length]!=-1)
            return dp[index][sum+ nums.length];

        int add= dpTopDown(nums, target, index+1,sum+nums[index], dp);
        int sub= dpTopDown(nums, target, index+1,sum-nums[index], dp);
        dp[index][sum+ nums.length]=add+sub;
        return add+sub;
    }

    private static int dfs(int[] nums, int target, int index, int sum) {
        if(index== nums.length){
            if(sum==target) return 1;
            return 0;
        }
        int add= dfs(nums, target, index+1,sum+nums[index]);
        int sub= dfs(nums, target, index+1,sum-nums[index]);
        return add+sub;

    }

    private static int targetSumUsingBottomUpDP(int[] nums, int target){
        if(edgeCase(nums, target)) return 2;
        int total = Arrays.stream(nums).sum();
        long[][] dp = new long[nums.length][(total*2)+1];
        int tmp = nums[0];
        dp[0][total+tmp] = 1;
        dp[0][total-tmp] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < (total*2)+1; j++) {
                if(dp[i-1][j]==0)
                    continue;
                else{
                    dp[i][j+nums[i]] = dp[i][j+nums[i]] + dp[i-1][j];
                    dp[i][j-nums[i]] = dp[i][j-nums[i]] + dp[i-1][j];
                }
            }
        }
        //Arrays.stream(dp).forEach(ar -> System.out.println(Arrays.toString(ar)));
        return (int)dp[nums.length-1][target];
    }

    private static boolean edgeCase(int[] nums, int target){
        return nums.length==1 && target==0;
    }
}