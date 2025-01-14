package in.algo.dynamicProgramming.palindrome;


/*
*
* Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
*
* */
public class CountNumberOfPalindromicSubStrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("fdsklf"));
        System.out.println(countSubstrings("aaaaa"));
    }
    private static int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }

        dfs(0, s.length()-1, s, dp);
        int result = s.length();
        for (int[] arr: dp) {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == 1) result++;
            }
        };
        return result;
    }

    private static int dfs(int i, int j, String s, int[][] dp){
        if(i == j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int count = 0;
        if(s.charAt(i) == s.charAt(j)){
            if(j-i==1) count = 1;
            else count = dfs(i+1, j-1, s, dp);
        }
        dfs(i+1, j, s, dp);
        dfs(i, j-1, s, dp);
        return dp[i][j] = count;
    }
}