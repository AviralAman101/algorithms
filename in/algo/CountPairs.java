package in.algo;
/*
* Given two sorted matrices mat1 and mat2 of size n x n of elements. Each matrix contains numbers
* arranged in strictly ascending order, with each row sorted from left to right, and the last
* element of a row being smaller than the first element of the next row. You're given a target
* value, x, your task is to find and count all pairs {a, b} such that a is from mat1 and b is from
* mat2 where sum of a and b is equal to x.

Example 1:

Input:
n = 3, x = 21
mat1 = {{1, 5, 6},
        {8, 10, 11},
        {15, 16, 18}}
mat2 = {{2, 4, 7},
        {9, 10, 12},
        {13, 16, 20}}
OUTPUT: 4
Explanation: The pairs whose sum is found to be 21 are (1, 20), (5, 16), (8, 13), (11, 10).
Example 2:

Input:
n = 2, x = 10
mat1 = {{1, 2},
        {3, 4}}
mat2 = {{4, 5},
        {6, 7}}
Output: 2
Explanation: The pairs whose sum found to be 10 are (4, 6), (3, 7).
* */
public class CountPairs {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[][]{{1, 5, 6},
                {8, 10, 11},
                {15, 16, 18}}, new int[][]{{2, 4, 7},
                {9, 10, 12},
                {13, 16, 20}}, 3,21));
    }
    static int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int m1 = mat1[i][j];
                    if(m1 > x) break;
                    m1=x-m1;
                    count+=countNumberOfPairs(mat2, n, m1);
            }
        }
        return count;
    }

    private static int countNumberOfPairs(int[][] mat2, int n, int m1) {
        int c=0;
        for (int i = 0; i < n; i++) {
            if(mat2[i][0]<=m1 && mat2[i][n-1]>=n){
                for (int j = 0; j < n; j++) {
                    if(mat2[i][j]==m1) c++;
                }
            }
        }
        return c;
    }
}
