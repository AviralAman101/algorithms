package in.algo.random.dp;

import java.util.Arrays;


/*
* Given two strings x and y, and two values costX and costY, the task is to find the minimum cost required to make the given two strings identical. You can delete characters from both the strings. The cost of deleting a character from string X is costX and from Y is costY. The cost of removing all characters from a string is the same.

Example 1:

Input: x = "abcd", y = "acdb", costX = 10
       costY = 20.
Output: 30
Explanation: For Making both strings
identical we have to delete character
'b' from both the string, hence cost
will be = 10 + 20 = 30.
Example 2:

Input : x = "ef", y = "gh", costX = 10
        costY = 20.
Output: 60
Explanation: For making both strings
identical, we have to delete 2-2
characters from both the strings, hence
cost will be = 10 + 10 + 20 + 20 = 60.
Your Task:
You don't need to read or print anything. Your task is to complete the function findMinCost() which takes both strings and the costs as input parameters and returns the minimum cost.

Expected Time Complexity: O(|x|*|y|)
Expected Space Complexity: O(|x|*|y|)

Constraints:
1 ≤ |x|, |y| ≤ 1000
1<= costX, costY <= 105
*
* */

public class MinimumCostToIdenticalString {
    public static void main(String[] args) {
        MinimumCostToIdenticalString mcost = new MinimumCostToIdenticalString();
        System.out.println(mcost.findMinCost("abcd","acdb", 10,20 ));
    }
    public int lcs(String X, String Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];

        /* Following steps build L[m+1][n+1] in bottom
           up fashion. Note that L[i][j] contains length
           of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;

                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;

                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        //Arrays.stream(L).forEach(a -> System.out.println(Arrays.toString(a)));

        /* L[m][n] contains length of LCS for X[0..n-1] and
           Y[0..m-1] */
        return L[m][n];
    }

    public int findMinCost(String x, String y, int costX, int costY) {
        // Find LCS of X[] and Y[]
        int m = x.length(), n = y.length();
        int len_LCS = lcs(x, y, m, n);

        // Cost of making two strings identical is SUM of
        // following two
        //   1) Cost of removing extra characters
        //      from first string
        //   2) Cost of removing extra characters from
        //      second string
        return costX * (m - len_LCS) + costY * (n - len_LCS);
    }
}
