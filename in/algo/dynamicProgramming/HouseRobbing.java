package in.algo.dynamicProgramming;


import java.util.Arrays;

/*
* Statement: You are a professional robber planning to rob houses along a street.
* Each house has a certain amount of money stashed. However,
* adjacent houses have security systems that will alert the police
* if two adjacent houses are broken into on the same night.
* Your goal is to maximize the amount of money you can rob from
* the houses without triggering the security systems.



Example 1:

Input: nums = [1, 2, 3, 1]

Output: 4

Explanation: In this case, you can rob house 1 (money = 1) and
* then rob house 3 (money = 3). The total amount you can rob is 1 + 3 = 4.



Example 2:

Input: nums = [2, 7, 9, 3, 1]

Output: 12 Explanation: Here, you can rob house 1 (money = 2),
* rob house 3 (money = 9), and rob house 5 (money = 1).
* The total amount you can rob is 2 + 9 + 1 = 12.



Your task is to determine the maximum amount of money you can rob
*  from the houses without alerting the police, given the amounts
* of money in each house represented by the array nums.
*
* */
public class HouseRobbing {
    public static void main(String[] args) {
        System.out.println(maxRobbingBottomUp(new int[]{1,2,3,1}));
    }

    private static int maxRobbery(int[] houses) {
        if (houses.length == 1) return houses[0];
        if (houses.length == 0) return 0;
        int sum = 0;
        for (int a : houses) sum += a;
        if (sum == 0) return 0;
        int[][] dp = new int[houses.length][sum];
        Arrays.stream(dp).forEach(dx -> Arrays.fill(dx, -1));
        return (maxRobbingDFS(houses, 0, 0, dp));
    }

    private static int maxRobbingDFS(int[] houses, int index, int total, int[][] dp) {
        if (index >= houses.length) return total;
        if (dp[index][total] != -1) return dp[index][total];
        int take = maxRobbingDFS(houses, index + 2, total + houses[index], dp);
        int notTake = maxRobbingDFS(houses, index + 1, total, dp);
        dp[index][total] = Math.max(take, notTake);
        return Math.max(take, notTake);
    }

    private static int maxRobbingBottomUp(int[] houses){
        int dp[] = new int[houses.length];
        if(dp.length == 1) return houses[0];
        dp[0] = houses[0];
        for (int i = 1; i < houses.length; i++) {
            int max = Math.max(houses[i] + ((i-2) >=0 ? dp[i-2] : 0), dp[i-1]);
            dp[i] = max;
        }
        System.out.println(Arrays.toString(dp));
        return dp[houses.length-1];
    }
}
