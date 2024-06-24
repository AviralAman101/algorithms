package in.algo.amazon;


import java.util.Arrays;

/*
*
* You are given an integer k and matrix mat. Return a matrix where it is rotated Left k times.

Examples:

Input: k=1, mat=[[1,2,3],[4,5,6],[7,8,9]]
Output:
1 2 3
4 5 6
7 8 9
Explanation: Rotate the matrix by one
1 2 3       2 3 1
4 5 6  =>  5 6 4
7 8 9       8 9 7
Input: k=2, mat=[[1,2,3],[4,5,6],[7,8,9]]
Output:
3 1 2
6 4 5
9 7 8
Explanation: After rotating the matrix looks like
1 2 3       2 3 1       3 1 2
4 5 6  =>  5 6 4  =>   6 4 5
7 8 9       8 9 7       9 7 8
Expected Time Complexity: O(n*m)
Expected Auxillary Space: O(n*m)

Constraints:
1<= mat.size, mat[0].size, mat[i][j] <=1000
1<=k<=10000
*
* */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] ints = rotateMatrix(2, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Arrays.stream(ints).forEach(ar -> System.out.println(Arrays.toString(ar)));
    }

    private static int[][] rotateMatrix(int k, int mat[][]) {
        // code here
        k = k%mat[0].length;
        int[][] ints = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int moveLoc = j-k < 0 ? mat[i].length - Math.abs(j-k) : j-k;
                ints[i][moveLoc] = mat[i][j];
            }
        }
        return ints;
    }

    private static void leftRotate(int arr[], int d, int n)
    {
        /* To handle if d >= n */
        d = d % n;
        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    /*UTILITY FUNCTIONS*/

    /* function to print an array */
    private static void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    /*Function to get gcd of a and b*/
    private static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
