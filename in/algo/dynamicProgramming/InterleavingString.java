package in.algo.dynamicProgramming;


import java.util.HashMap;

/*
*
*
* Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m
substrings
 respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.



Example 1:


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true


Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.
*
* */
public class InterleavingString {
    public static void main(String[] args) {
        System.out.println(isInterleave("a","b","a"));
        //Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
        System.out.println(isInterleave("aabd","ebca","aabedbca"));
        System.out.println(isInterleave("aabcc","dbbca","aadbbbaccc"));
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
        //aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    }

    private static boolean isInterleave(String s1, String s2, String s3) {
        HashMap<String, Boolean> dp = new HashMap<>();
        return dfs(s1, s2, s3, 0,0,0, dp);
    }

    private static boolean dfs(String s1, String s2, String s3, int i, int j,int k, HashMap<String, Boolean> dp) {
        String key = i + "*" + j + "*" + k;
        if (dp.containsKey(key)) return dp.get(key);
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 <= i && l2 <= j && l3 <= k) {
            return true;
        }

        boolean left = false;
        if (i < l1 && k < l3 && s1.charAt(i) == s3.charAt(k)) {
            left = dfs(s1, s2, s3, i + 1, j, k + 1, dp);
        }

        boolean right = false;
        if (j < l2 && k < l3 && s2.charAt(j) == s3.charAt(k)) {
            right = dfs(s1, s2, s3, i, j + 1, k + 1, dp);
        }
        boolean result = left || right;
        dp.put(key, result);
        return result;
    }
}
