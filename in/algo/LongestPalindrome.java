package in.algo;

public class LongestPalindrome {

    // Given a string S, find the longest palindromic substring in S.
    // Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S).
    // Palindrome string: A string that reads the same backward.
    // More formally, S is a palindrome if reverse(S) = S. In case of conflict,
    // return the substring which occurs first ( with the least starting index).

    public static void main(String[] args) {
        String s = "moaomaxcvbnh";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome("aaaabbaa"));
    }

    static String longestPalindrome(String x) {
        int fStart=0;
        int fEnd=1;
        for (int index = 0; index < x.length(); index++) {
            char left,right,rightOdd;
            boolean odd=true,even = true;
            int i = 0;
            while (index - 1 - i >= 0 && index + i < x.length()) {
                left = x.charAt(index - 1 - i);
                right = x.charAt(index + i);
                // Finding Palindrome with odd length
                if (odd && index + i + 1 < x.length()) {
                    rightOdd = x.charAt(index + i + 1);
                    if (left == (rightOdd)) {
                        if ((fEnd-fStart) < ((index + i + 2)-(index - 1 - i)))
                        {
                            fStart = index - 1 - i;
                            fEnd = index + i + 2;
                        }
                    } else odd = false;
                }else odd = false;
                // Finding Palindrome with even length
                if (even && right == (left)) {
                    if ((fEnd-fStart) < ((index + i + 1)-(index - 1 - i)))
                    {
                        fStart = index - 1 - i;
                        fEnd =  index + i + 1;
                    }
                }else even=false;
                if(!odd && !even) break;
                i++;
            }
        }
        return x.substring(fStart,fEnd);
    }
}
