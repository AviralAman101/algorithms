package in.algo;

import java.util.Arrays;

/*
* Given two arrays a and b of positive integers of size n and m where n >= m, the task is
* to maximize the dot product by inserting zeros in the second array but you cannot disturb the order of elements.

Dot product of array a and b of size n is a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1].

Example 1:

Input:
n = 5, a[] = {2, 3, 1, 7, 8}
m = 3, b[] = {3, 6, 7}
Output:
107
Explanation:
We get maximum dot product after inserting 0 at first and third positions in second array.
Therefore b becomes {0, 3, 0, 6, 7}.
Maximum dot product = 2*0 + 3*3 + 1*0 + 7*6 + 8*7 = 107.
Example 2:

Input:
n = 3, a[] = {1, 2, 3}
m = 1, b[] = {4}
Output:
12
Explanation:
We get maximum dot product after inserting 0 at first and second positions in second array.
Therefor b becomes {0, 0, 4}.
Maximum Dot Product = 1*0 + 2*0 + 3*4 = 12.*/
public class MaxDotProduct {
    public static void main(String[] args) {
        int[] n3 = new int[]{2, 3, 1, 7, 8} ;
        int[] n4 = new int[]{3, 6, 7};
        maxDotProduct(5, 3, n3, n4);
//        int[] n1 = new int[]{6, 3, 6, 3, 8 ,6 ,3, 9} ;
//        int[] n2 = new int[]{6 ,3 ,9 ,8 ,4 ,2};
//        int i = maxDotProduct(8, 6, n1, n2);
//        System.out.println(i);
    }
/*6 3 6 3 8 6 3 9
  6 3 9 8 4 2*/
    public static int maxDotProduct(int N, int M, int A[], int B[])
    {
        // Create 2D Matrix that stores dot product
        // dp[i+1][j+1] stores product considering B[0..i]
        // and A[0...j]. Note that since all M > N, we fill
        // values in upper diagonal of dp[][]
        int[][] dp = new int[M + 1][N + 1];

        // Traverse through all elements of B[]
        for (int i = 1; i <= M; i++) {

            // Consider all values of A[] with indexes greater
            // than or equal to i and compute dp[i][j]
            for (int j = i; j <= N; j++) {

                // Two cases arise
                // 1) Include A[j]
                // 2) Exclude A[j] (insert 0 in B[])
                int dp1 = dp[i - 1][j - 1];
                int a1 = A[j - 1];
                int b1 = B[i - 1];
                int dp2 = dp[i][j - 1];
                dp[i][j] = Math.max(dp1 + (a1 * b1), dp2);
            }
        }/*
[0, 0, 0, 0, 0, 0]
[0, 6, 9, 9, 21, 24]
[0, 0, 24, 24, 51, 69]
[0, 0, 0, 31, 73, 107]

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        */
        // return Maximum Dot Product
        return dp[M][N];
    }
}
