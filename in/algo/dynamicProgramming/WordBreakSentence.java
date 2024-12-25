package in.algo.dynamicProgramming;

import java.util.*;

/*
* Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []


Constraints:

1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
Input is generated in a way that the length of the answer doesn't exceed 105.
*
* */
public class WordBreakSentence {
    public static void main(String[] args) {
        //Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
        System.out.println(wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple")));
    }

    private static List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> cache = new HashMap<>();
        return dfs(s, wordDict, cache);
    }

    private static List<String> dfs(String s, List<String> wordDict,
                                    HashMap<String, List<String>> cache) {
        if (s.isEmpty()) return Collections.emptyList();
        if (cache.containsKey(s)) return cache.get(s);
        ArrayList<String> result = new ArrayList<>();

        for (String word : wordDict) {
            if (!s.startsWith(word)) continue;
            if (word.length() == s.length()) result.add(word);
            else {
                List<String> sentences = dfs(s.substring(word.length()), wordDict, cache);
                for (String sen : sentences)
                    result.add(word + " " + sen);
            }
        }

        cache.put(s, result);
        return result;
    }
}
