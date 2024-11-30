package in.algo.dynamicProgramming;


import java.util.Arrays;

/*
*
* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character


Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')


Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
* */
public class MinimumDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minimumDistanceBottomUpApproachMethod2("intention", "execution"));
        System.out.println(minimumDistanceBottomUpApproachMethod2("horse", "ros"));
    }

    private static int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dfs(s1, s2, dp);
    }

    private static int dfs(String s1, String s2, int[][] dp) {
        if (dp[s1.length()][s2.length()] != -1)
            return dp[s1.length()][s2.length()];

        while (s1.length() > 0 && s2.length() > 0) {
            if (s1.charAt(0) != s2.charAt(0))
                break;
            s1 = s1.substring(1);
            s2 = s2.substring(1);
        }

        if (s1.length() == 0)
            return s2.length();

        if (s2.length() == 0)
            return s1.length();

        return 1 + Math.min(Math.min(dfs(s1.substring(1), s2.substring(1), dp), dfs(s1, s2.substring(1), dp)),
                dfs(s1.substring(1), s2, dp));
    }

    private static int minimumDistanceBottomUpApproachMethod2(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i + 1][j]), dp[i][j + 1]);
                } else {
                    dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i][j], dp[i + 1][j]), dp[i][j + 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

}
