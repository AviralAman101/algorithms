package in.algo;

/*
* Given a n x n matrix such that each of its cells contains some coins. Count the number of ways to
* collect exactly k coins while moving from top left corner of the matrix to the bottom right.
* From a cell (i, j), you can only move to (i+1, j) or (i, j+1).

Example 1:

Input:
k = 12, n = 3
arr[] = [[1, 2, 3],
         [4, 6, 5],
         [3, 2, 1]]
Output:
2
Explanation:
There are 2 possible paths with exactly 12 coins, (1 + 2 + 6 + 2 + 1) and (1 + 2 + 3 + 5 + 1).
Example 2:

Input:
k = 16, n = 3
arr[] = [[1, 2, 3],
         [4, 6, 5],
         [9, 8, 7]]
Output:
0
Explanation:
There are no possible paths that lead to sum=16
Your Task:
You don't need to read input or print anything. Your task is to complete the
* function numberOfPath() which takes n, k and 2D matrix arr[][] as input parameters and returns the number of possible
* paths.*/

import java.util.Arrays;

public class NumberOfPathsAmazon {
    public static void main(String[] args) {
        NumberOfPathsAmazon number = new NumberOfPathsAmazon();
        number.numberOfPath(3, 12 , new int[][]{{1,2,3},{4,6,5},{3,2,1}});
    }
    public long f(int i, int j, int n, int k, int a[][], long dp[][][]) {

        if (i == n - 1 && j == n - 1 && k == a[i][j]) {
            return 1;
        }

        if (i >= n || j >= n || k < 0) {
            return 0;
        }

        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        // Recursively calculate the number of paths by moving down and right
        long d = f(i + 1, j, n, k - a[i][j], a, dp);
        long r = f(i, j + 1, n, k - a[i][j], a, dp);

        // Store the calculated result in dp[i][j][k]
        return dp[i][j][k] = d + r;
    }

    // Function to calculate the total number of paths with a given sum "K"
    // Initializes the dp array with -1 and calls the recursive function f

    public long numberOfPath(int N, int K, int[][] arr) {
        long dp[][][] = new long[N][N][K + 1];

        // Initialize dp array with -1
        for (long row[][] : dp) {
            for (long row2[] : row) {
                Arrays.fill(row2, -1);
            }
        }

        return f(0, 0, N, K, arr, dp);
    }
}
