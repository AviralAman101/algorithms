package in.algo.amazon;


/*
*
* Given a binary matrix mat of size n * m, find out the maximum length of a
* side of a square sub-matrix with all 1s.

Examples:

Input: n = 6, m = 5
mat = [[0, 1, 1, 0, 1],
       [1, 1, 0, 1, 0],
       [0, 1, 1, 1, 0],
       [1, 1, 1, 1, 0],
       [1, 1, 1, 1, 1],
       [0, 0, 0, 0, 0]]
Output: 3
Explanation:

The maximum length of a side of the square sub-matrix is 3 where every element is 1.
Input: n = 2, m = 2
mat = [[1, 1],
       [1, 1]]
Output: 2
Explanation: The maximum length of a side of the square sub-matrix is 2.
* The matrix itself is the maximum sized sub-matrix in this case.
Input: n = 2, m = 2
mat = [[0, 0],
       [0, 0]]
Output: 0
Explanation: There is no 1 in the matrix.
Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)
* */
public class LargestSquareMatrix {
    public static void main(String[] args) {
        System.out.println(maxSquare(6,5, new int[][]{{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}}));
    }
    static int maxSquare(int n, int m, int mat[][]) {
        int[][] dp = new int[n][m];
        boolean flag=false;

        for (int i = 0; i < n; i++) {
            int i1 = mat[i][0];
            if(!flag && i1==1) flag=true;
            dp[i][0] = i1;
        }
        for (int i = 1; i < m; i++) {
            int i1 = mat[0][i];
            if(!flag && i1==1) flag=true;
            dp[0][i] = i1;
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(mat[i][j] != 0){
                    int i1 = 1 + Math.min(dp[i - 1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                    if(max < i1) max=i1;
                    dp[i][j] = i1;
                }
            }
        }
        if(max==0 && flag) return 1;
        return max;
    }
}
