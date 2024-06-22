package in.algo.dynamicProgramming;


/*
* Statement: You are given a matrix with dimensions m * n, consisting of ones and zeros.
* Your task is to determine the number of square submatrices
* within the matrix that contain only ones.



Example 1:

Input: matrix =

[

  [0, 1, 1, 1],

  [1, 1, 1, 1],

  [0, 1, 1, 1]

]

Output: 15

Explanation: In this case, there are 10 squares of side 1 (each containing a single one),
* 4 squares of side 2 (each containing a 2x2 square of ones),
* and 1 square of side 3 (containing a 3x3 square of ones).
* The total number of squares is 10 + 4 + 1 = 15.



Example 2:

Input: matrix =

[

  [1, 0, 1],

  [1, 1, 0],

  [1, 1, 0]

]

Output: 7

Explanation: In this example, there are 6 squares of side 1
* (each containing a single one) and 1 square of side 2 (containing a 2x2 square of ones).
* The total number of squares is 6 + 1 = 7.



The goal is to count the number of square submatrices within the given matrix that consist entirely of ones.
*
*
* */
public class CountSquareSumMatrices {
    public static void main(String[] args) {
        System.out.println(countSqMatrices(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}, 3, 4));
    }

    private static int countSqMatrices(int[][] matrix, int n, int m){
        int count =0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
            if(matrix[i][0] != 0) count++;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
            if(matrix[0][i] != 0) count++;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(matrix[i][j] != 0){
                    int tempCount = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i][j-1]));
                    count+=tempCount;
                    dp[i][j] = tempCount;
                }
            }
        }
        //Arrays.stream(dp).forEach(ar -> System.out.println(Arrays.toString(ar)));

        return count;
    }
}
