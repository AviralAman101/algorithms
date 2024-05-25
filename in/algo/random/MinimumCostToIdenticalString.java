package in.algo.random;

import java.util.Arrays;

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
