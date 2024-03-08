package in.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
*
* Given a string s of length n, find the longest repeating non-overlapping substring in it. In other words find 2 identical substrings of maximum length which do not overlap. Return the longest non-overlapping substring. Return "-1" if no such string exists.

Note: Multiple Answers are possible but you have to return the substring whose first occurrence is earlier.

For Example: "abhihiab", here both "ab" and "hi" are possible answers. But you will have to return "ab" because it's first occurrence appears before the first occurrence of "hi".

Example 1:

Input:
n = 9
s = "acdcdacdc"
Output:
"acdc"
Explanation:
The string "acdc" is the longest Substring of s which is repeating but not overlapping.
Example 2:

Input:
n = 7
s = "heheheh"
Output:
"heh"
Explanation:
The string "heh" is the longest Substring of s which is repeating but not overlapping.*/
public class LongestRepeatingString {
    public static void main(String[] args) {
        System.out.println(longestSubstring("abaabbbbbaa", 11));
    }

    static String longestSubstring(String s, int n) {
        // code here
        String prefix="";
        String suffix="";
        String longest="";
//        int x=0;
//        int y=0;
        for (int i = 0; i < n-1; i++) {
//            y++;
            prefix += s.charAt(i);
            suffix = s.substring(i+1);
            int sufLength = suffix.length();
            int lngLength = longest.length();
            if(sufLength <= lngLength) break;
            boolean b = sufLength < prefix.length();

            if(lngLength >=prefix.length())
                continue;

            int j = b ? prefix.length()- sufLength :0;
            for (; j < prefix.length() && prefix.length()-j > lngLength; j++) {
                //x++;
//                System.out.println(prefix.substring(j));
//                System.out.println("prefix check ------------");
                String ss = prefix.substring(j);
                if(suffix.contains(ss))
                    longest=ss;
            }
        }
//        System.out.println(y);
//        System.out.println(x);
        return longest == "" ? "-1" : longest;
    }

}
