package in.algo.dynamicProgramming.palindrome;


import java.util.Arrays;

/*
*
* Given a string S, find the longest palindromic substring in S.
* Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S).
* Palindrome string: A string which reads the same backwards.
* More formally, S is palindrome if reverse(S) = S. Incase of conflict,
* return the substring which occurs first ( with the least starting index ).


Example 1:

Input:
S = "aaaabbaa"
Output:
aabbaa
Explanation:
The longest palindrome string present in
the given string is "aabbaa".

Your Task:
You don't need to read input or print anything. Your task is to complete the
* function longestPalindrome() which takes string S as input parameters and
* returns longest pallindrome present in string.


Expected Time Complexity: O(|S|2)
Expected Auxiliary Space: O(1)
*
* */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaabbaa"));
        System.out.println(longestPalindrome("abcbq"));
        System.out.println(longestPalindrome("asd"));
        System.out.println(longestPalindrome("qrrc"));
        System.out.println(longestPalindrome("ayaxzfbjbkrxiri"));
    }
    static String str;
    private static String longestPalindrome(String S){
        int[][] dp = new int[S.length()][S.length()];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        str=null;
        dfs(0,S.length()-1, S, dp);
        if(str == null && S.length()>0) str = String.valueOf(S.charAt(0));
        return str;
    }

    private static int dfs(int i, int j, String s, int[][] dp){
        if(i == j) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)){
            if(j-i+1 == 2) {
                if(str == null || str.length()<2){
                    str = s.substring(i, j+1);
                }
                return 2;
            }
            else if (j-i+1 == 2 + dfs(i+1, j-1, s, dp)) {
                if(str==null || str.length()<j-i+1){
                    str = s.substring(i,j+1);
                }
                return j-i+1;
            }
        }
        int right = dfs(i, j-1, s, dp);
        int left = dfs(i+1, j, s, dp);

        return dp[i][j] = Math.max(left, right);
    }
}
