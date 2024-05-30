package in.algo.random.dp;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lcs("abcd","abc",4,3));
    }
    public static int lcs(String X, String Y, int m, int n) {
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

        /* L[m][n] contains length of LCS for X[0..n-1] and
           Y[0..m-1] */
        return L[m][n];
    }
}
