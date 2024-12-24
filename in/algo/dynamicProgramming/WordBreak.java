package in.algo.dynamicProgramming;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
*
* Given a string s and a dictionary of strings wordDict, return true
* if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused
multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
*
* */
public class WordBreak {
    public static void main(String[] args) {
        //Input: s = "applepenapple", wordDict = ["apple","pen"]
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple","pen")));
        //Input: s = "leetcode", wordDict = ["leet","code"]
        System.out.println(wordBreak("leetcode", Arrays.asList("leet","code")));
        //Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
        System.out.println(wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        HashSet<String> strs = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(strs.contains(s.substring(j, i)) && dp[j]){
                    dp[i] = true; break;
                }
            }
        }
        return dp[s.length()];
    }
}
