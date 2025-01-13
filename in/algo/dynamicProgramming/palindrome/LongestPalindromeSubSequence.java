package in.algo.dynamicProgramming.palindrome;

/*
*
* Given a string s, find the longest palindromic subsequence.

A subsequence of a given sequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements

Examples:

Input: s = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.

Input: s = "abcd"
Output: 1
Explanation: "a", "b", "c" and "d" are palindromic and all have a length 1.

Input: s = "agbdba"
Output: 5
Explanation: The longest palindromic subsequence is "abdba", which has a length of 5. The characters in this subsequence are taken from the original string "agbdba", and they maintain the order of the string while forming a palindrome.

* Constraints:
1 ≤ s.size() ≤ 1000
The string contains only lowercase letters.
*
* */

import java.util.Arrays;

public class LongestPalindromeSubSequence {
    public static void main(String[] args) {
        System.out.println(longestPalinSubseq("agbdba"));
        System.out.println(longestPalinSubseq("bbabcbcab"));
        System.out.println(longestPalinSubseq("abcd"));
    }

    private static int longestPalinSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int[] arr: dp) Arrays.fill(arr, -1);
        return dfs(s, 0, s.length()-1, dp);
    }

    private static int dfs(String s, int start, int end, int[][] dp){
        if(start == end) return 1;
        if(start> end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        int length = 0;
        if(s.charAt(start) == s.charAt(end)){
            length = 2 + dfs(s, start+1, end-1, dp);
        } else {
            length = Math.max(dfs(s, start+1, end, dp), dfs(s, start, end-1, dp));
        }
        return dp[start][end] = length;
    }
}
