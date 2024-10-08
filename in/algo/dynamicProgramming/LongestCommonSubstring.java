package in.algo.dynamicProgramming;


/*
*
* You are given two strings str1 and str2. Your task is to find
* the length of the longest common substring among the given strings.

Examples:

Input: str1 = "ABCDGH", str2 = "ACDGHR"
Output: 4
Explanation: The longest common substring is "CDGH" which has length 4.
*
*
Input: str1 = "ABC", str2 = "ACB"
Output: 1
Explanation: The longest common substrings are "A", "B", "C" all having length 1.
*
*
Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).
*
*
* */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(lcsLength("hel","elf"));
    }

    private static  int lcsLength(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int max = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    int length = 1 + dp[i - 1][j - 1];
                    dp[i][j] = length;
                    if(length>max) max = length;
                }
            }
        }

        return max;
    }
}
