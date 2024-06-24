package in.algo.random;


/*
*
* A matrix is constructed of size n*n and given an integer ‘q’.
* The value at every cell of the matrix is given as, M(i,j) = i+j,
* where ‘M(i,j)' is the value of a cell, ‘i’ is the row number,
* and ‘j’ is the column number. Return the number of cells having value ‘q’.

Note: Assume, the array is in 1-based indexing.

Examples:

Input: n = 4, q = 7
Output: 2
Explanation: Matrix becomes
2 3 4 5
3 4 5 6
4 5 6 7
5 6 7 8
The count of 7 is 2.
Input: n = 5, q = 4
Output: 3
Explanation: Matrix becomes
2 3 4 5 6
3 4 5 6 7
4 5 6 7 8
5 6 7 8 9
6 7 8 9 10
The count of 4 is 3.
Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

*
* * */

public class FindOccurrenceInMatrix {
    public static void main(String[] args) {
        System.out.println(sumMatrix(1, 2));
        System.out.println(sumMatrix(5, 4));
        System.out.println(sumMatrix(4, 7));
    }

    private static long sumMatrix(int n, int q){
        if(q > 2*n) return 0; // base case

        long max = n+1;
        long mod = Math.abs(max-q);
        
        return max-mod-1;
    }
}
