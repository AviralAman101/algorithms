package in.algo.dynamicProgramming;

/*
 *
 * Given a list of numbers [1,3,4] and a target n, count all the possible ways in which n can
 * be expressed as the sum of given numbers.
 * If there are no possible ways return 0.
 *
 * Example :
 * n = 4
 * list = [1,3,4]
 *
 * 1+1+1+1 = 4
 * 1+3 = 4
 * 3+1 = 4
 * 4 = 4
 *
 * Ans: 4 ways
 *
 *
 * */

import java.util.Arrays;
import java.util.List;

public class CountWaysToSum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4);
        int n = 4;

        //Method 1 : Slow
        System.out.println(numberOfWaysUsingDFS(n, list));

        //Method 2 : fast
        int max = list.stream().mapToInt(i -> i).max().getAsInt();
        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        System.out.println(numberOfWaysUsingTopDownApproach(n, list, dp));
        //System.out.println(Arrays.toString(dp));
    }

    private static long numberOfWaysUsingDFS(int n, List<Integer> list) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        int s = 0;
        for (int i = 0; i < list.size(); i++) {
            s += numberOfWaysUsingDFS(n - list.get(i), list);
        }
        return s;
    }

    private static long numberOfWaysUsingTopDownApproach(int n, List<Integer> list, int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        int s = 0;
        if (dp[n] != -1) return dp[n];
        for (int i = 0; i < list.size(); i++) {
            s += numberOfWaysUsingTopDownApproach(n - list.get(i), list, dp);
        }
        dp[n] = s;
        return s;
    }
}
