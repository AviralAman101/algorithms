package in.algo.dynamicProgramming;


import java.util.Arrays;

/*
*
* Given two strings word1 and word2, return the minimum number of operations
* required to convert word1 to word2.

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
*
* */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("hel", "el"));
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int[] ar : dp) Arrays.fill(ar, -1);
        return dfs(word1, word2,0 ,0 ,dp);
    }

    private static int dfs(String word1, String word2, int i, int j, int[][] dp) {
        if(dp[i][j] != -1) return dp[i][j];

        while (i<word1.length() && j< word2.length() && word1.charAt(i)==word2.charAt(j)){
            i++;
            j++;
        }

        if(i == word1.length()) return word2.length()-j;
        if(j == word2.length()) return word1.length()-i;
        
        int minSteps = 1 + Math.min(dfs(word1, word2, i + 1, j, dp), Math.min(dfs(word1, word2, i, j + 1, dp),
                dfs(word1, word2, i + 1, j + 1, dp)));
        dp[i][j] = minSteps;

        return minSteps;
    }
}
