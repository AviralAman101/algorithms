package in.algo.amazon;


/*
* Given a string str of length n, find if the string is K-Palindrome or not.
* A k-palindrome string transforms into a palindrome on removing at most k characters from it.


Example 1:

Input: str = "abcdecba"
n = 8, k = 1
Output: 1
Explaination: By removing 'd' or 'e'
we can make it a palindrome.

Example 2:

Input: str = "abcdefcba"
n = 9, k = 1
Output: 0
Explaination: By removing a single
character we cannot make it a palindrome.

Your Task:
You do not need to read input or print anything. Your task is to complete
* the function kPalindrome() which takes string str, n, and k as input
* parameters and returns 1 if str is a K-palindrome else returns 0.

*/
public class KPalindrome {
    public static void main(String[] args) {
        System.out.println(kPalindrome("llrtkmmobksqokichpgilgfqlgjsjgblfrcbqtmttqcgonotrlbhteocqigdnotfj", 65, 42));
        System.out.println(kPalindrome("abcdecba", 8, 1));
        System.out.println(kPalindrome("abcdefcba", 9, 1));
    }
    public static int isKPalin(String str, String revstr, int m, int n) {
        // Create a table to store results of subproblems
        int[][] dp = new int[m + 1][n + 1];

        // Fill dp[][] in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, only option is to
                // remove all characters of second string
                if (i == 0) dp[i][j] = j; // Min. operations = j

                    // If second string is empty, only option is to
                    // remove all characters of first string
                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last character
                    // and recur for remaining string
                else if (str.charAt(i - 1) == revstr.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                    // If last character are different, remove it
                    // and find minimum
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],  // Remove from str1
                            dp[i][j - 1]); // Remove from str2
            }
        }

        return dp[m][n];
    }

    public static int kPalindrome(String str, int n, int k) {
        StringBuilder revBuilder = new StringBuilder(str);
        String revstr = revBuilder.reverse().toString();

        if (isKPalin(str, revstr, n, n) <= 2 * k) return 1;
        return 0;
    }

    public static boolean isPailnlessEfficient(char[] k , int buffer, int start, int end){
        if(start == end) return true;
        while (k[start] == k[end]){
            if(start == end) return true;
            start++;
            end--;
            if(start> end) return true;
        } // abcbaxyz
        if(buffer !=0) {
            boolean checkLeft = isPailnlessEfficient(k, buffer - 1, start + 1, end);
            if(checkLeft) return checkLeft;
            boolean checkRight = isPailnlessEfficient(k, buffer-1, start, end-1);
            return checkRight;
        }
        return false;
    }

}
