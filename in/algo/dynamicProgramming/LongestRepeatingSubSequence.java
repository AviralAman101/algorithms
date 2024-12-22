package in.algo.dynamicProgramming;

/*
* Given string str, find the length of the longest repeating subsequence
* such that it can be found twice in the given string.

The two identified subsequences A and B can use the same ith character
* from string s if and only if that ith character has different indices
* in A and B. For example, A = "xax" and B = "xax" then the index of the
* first "x" must be different in the original string for A and B.

Examples :

Input: s = "axxzxy"
Output: 2
Explanation: The given array with indexes looks like
a x x z x y
0 1 2 3 4 5
The longest subsequence is "xx". It appears twice as explained below.
subsequence A
x x
0 1  <-- index of subsequence A
------
1 2  <-- index of s
subsequence B
x x
0 1  <-- index of subsequence B
------
2 4  <-- index of s
We are able to use character 'x' (at index 2 in s) in both subsequences
* as it appears on index 1 in subsequence A and index 0 in subsequence B.
Input: s = "axxxy"
Output: 2
Explanation: The given array with indexes looks like
a x x x y
0 1 2 3 4
The longest subsequence is "xx". It appears twice as explained below.
subsequence A
x x
0 1  <-- index of subsequence A
------
1 2  <-- index of s
subsequence B
x x
0 1  <-- index of subsequence B
------
2 3  <-- index of s
We are able to use character 'x' (at index 2 in s) in both subsequencesas
* it appears on index 1 in subsequence A and index 0 in subsequence B.
Constraints:
1 <= s.size() <= 103
*
* */

import java.util.Arrays;

public class LongestRepeatingSubSequence {
    public static void main(String[] args) {
        System.out.println(longestRepeatingSubSequence("xax"));
        System.out.println(longestRepeatingSubSequence("axxzxy"));
    }

    private static int longestRepeatingSubSequence(String s1){
        int[][] dp = new int[s1.length()+1][s1.length()+1];
        for (int[] ar: dp) Arrays.fill(ar, -1);
        return dfs( s1, s1.length(),s1.length(), dp);
    }
    private static int dfs(String s1, int i, int j, int[][] dp) {
        if(i == 0 || j==0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int a = 0;
        if(i != j && s1.charAt(i-1) == s1.charAt(j-1))
            a = 1+ dfs(s1, i-1, j-1, dp);
        dp[i][j] = Math.max(a, Math.max(dfs(s1, i-1, j, dp), dfs(s1, i, j-1, dp)));
        return dp[i][j];
    }
}
