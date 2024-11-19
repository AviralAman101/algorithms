package in.algo.dynamicProgramming;

import java.util.Arrays;

/*
*
* Given two strings s1 and s2. The task is to remove or insert
* the minimum number of characters from/in s1 to transform it into s2.
* It could be possible that the same character needs to be removed
* from one point of s1 and inserted into another point.
*

Examples :

Input: s1 = "heap", s2 = "pea"
Output: 3
Explanation: 'p' and 'h' deleted from heap. Then, 'p' is inserted at the beginning.
Input : s1 = "geeksforgeeks", s2 = "geeks"
Output: 8
Explanation: 8 deletions, i.e. remove all characters of the string "forgeeks".
Constraints:
1 ≤ s1.size(), s2.size() ≤ 1000
All the characters are lowercase English alphabets.
*
* */
public class MinimumNumberOfInsertionsAndDeletions {
    public static void main(String[] args) {
        System.out.println(minOperationsBottomUp("heap", "pea"));
    }

    private static int minOperations(String s1, String s2) {
        // Your code goes here
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] ar : dp) Arrays.fill(ar, -1);

        int longestSubsequence = dfs(s1, s2, 0, 0, dp);
        return s1.length() + s2.length() - (2 * longestSubsequence);
    }

    private static int dfs(String s1, String s2, int i, int j, int[][] dp) {
        if (s1.length() == i || s2.length() == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return 1 + dfs(s1, s2, i + 1, j + 1, dp);

        int left = dfs(s1, s2, i + 1, j, dp);
        int right = dfs(s1, s2, i, j + 1, dp);

        return dp[i][j] = Math.max(left, right);
    }

    private static int minOperationsBottomUp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int max = -1;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > max) max = dp[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return s1.length() + s2.length() - (2 * max);
    }
}
