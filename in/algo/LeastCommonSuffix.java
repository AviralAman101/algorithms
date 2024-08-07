package in.algo;

import java.util.Arrays;


/*
* Input : X = “zxabcdezy”, y = “yzabcdezx”
Output : 6
Explanation:
The longest common substring is “abcdez” and is of length 6.
* */
public class LeastCommonSuffix {
    /*
       Returns length of longest common substring
       of X[0..m-1] and Y[0..n-1]
    */
    static int LCSubStr(char[] X, char[] Y, int m, int n, int[][] LCStuff)
    {
        // Create a table to store
        // lengths of longest common
        // suffixes of substrings.
        // Note that LCSuff[i][j]
        // contains length of longest
        // common suffix of
        // X[0..i-1] and Y[0..j-1].
        // The first row and first
        // column entries have no
        // logical meaning, they are
        // used only for simplicity of program


        // To store length of the longest
        // common substring
        int result = 0;

        // Following steps build
        // LCSuff[m+1][n+1] in bottom up fashion
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    LCStuff[i][j] = 0;
                else if (X[i - 1] == Y[j - 1]) {
                    LCStuff[i][j]
                            = LCStuff[i - 1][j - 1] + 1;
                    result = Integer.max(result,
                            LCStuff[i][j]);
                }
                else
                    LCStuff[i][j] = 0;
            }
        }
        return result;
    }

    // Driver Code
    public static void main(String[] args)
    {
        String X = "abcd";
        String Y = "acdb";

        int m = X.length();
        int n = Y.length();
        int LCStuff[][] = new int[m + 1][n + 1];
        System.out.println(
                "Length of Longest Common Substring is "
                        + LCSubStr(X.toCharArray(), Y.toCharArray(), m,
                        n, LCStuff));
        Arrays.stream(LCStuff).forEach(s -> System.out.println(Arrays.toString(s)));
    }
}
