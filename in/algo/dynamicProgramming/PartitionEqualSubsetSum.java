package in.algo.dynamicProgramming;


import java.util.Arrays;

/*

*
* Statement: You are given an integer array called nums.
* Your task is to determine whether it is possible to partition the array
* into two subsets such that the sum of the elements in both subsets is equal.
*  If it is possible, return true; otherwise, return false.



Example 1:

Input: nums = [1, 5, 11, 5]

Output: true

Explanation: In this case, the array can be partitioned into two
* subsets with equal sums: [1, 5, 5] and [11].



Example 2:

Input: nums = [1, 2, 3, 5]

Output: false

Explanation: Here, it is not possible to partition the array into subsets with equal sums.



The goal is to determine whether it is feasible to split the `nums` array
* into two subsets such that the sum of their elements is equal.
*
* */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println(partitionSubset(new int[]{1, 2, 3, 5}));
    }

    private static boolean partitionSubset(int[] sums){
        int sum = Arrays.stream(sums).sum();
        if(sum % 2 != 0) return false;
        boolean[] dp = new boolean[(sum/2)+1];
        dp[0] = true;
        for (int i = 0; i < sums.length; i++) {
            for (int j = sum/2; j >0 ; j--) {
                if((j-sums[i]>=0) && dp[j-sums[i]]) dp[j]=true;
            }
        }
        return dp[sum/2];
    }
}
