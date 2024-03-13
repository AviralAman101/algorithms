package in.algo;


import java.util.Arrays;

/*
* Given a square matrix mat[][] of n*n size, the task is to determine the diagonal pattern which is a
* linear arrangement of the elements of the matrix as depicted in the following example:



Example 1:

Input:
n = 3
mat[][] = {{1, 2, 3},
           {4, 5, 6},
           {7, 8, 9}}
Output: {1, 2, 4, 7, 5, 3, 6, 8, 9}
Explaination:
Starting from (0, 0): 1,
Move to the right to (0, 1): 2,
Move diagonally down to (1, 0): 4,
Move diagonally down to (2, 0): 7,
Move diagonally up to (1, 1): 5,
Move diagonally up to (0, 2): 3,
Move to the right to (1, 2): 6,
Move diagonally up to (2, 1): 8,
Move diagonally up to (2, 2): 9
There for the output is {1, 2, 4, 7, 5, 3, 6, 8, 9}.
Example 2:

Input:
n = 2
mat[][] = {{1, 2},
           {3, 4}}
Output: {1, 2, 3, 4}
Explaination:
Starting from (0, 0): 1,
Move to the right to (0, 1): 2,
Move diagonally down to (1, 0): 3,
Move to the right to (1, 1): 4
There for the output is {1, 2, 3, 4}.*/
public class PrintMatrixDiagonally {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(matrixDiagonally(new int[][]{{1, 2},
                {3, 4}})));
        System.out.println(Arrays.toString(matrixDiagonally(new int[][]{   {7 ,5, 6 ,2 ,3 },
                                        {4 ,7 ,2, 5 ,8 },
                                        {7 ,6 ,4, 7 ,3 }
                                        ,{2 ,5 ,8 ,7 ,8 },
                                        {6, 4, 5 ,4 ,7}})));
        }
    public static int[] matrixDiagonally(int[][] mat) {


        int n = mat.length;
        int[] ints = new int[n * n];
        ints[0] = (mat[0][0]);
        recursive(0,0,0, n, mat, ints);
        //System.out.println(Arrays.toString(ints));
        return ints;
    }

    static void recursive(int i, int j, int total, int n, int[][]mat, int[] ints){
        if(total==(Math.pow(n,2)-1)) {
            return;
        }

        total++;
        if((j+1)<n){ //move right
            ints[total]=(mat[i][++j]);
        } else { //move down
            //System.out.println(Arrays.toString(ints));
            ints[total]=(mat[++i][j]);
        }
        while ((i+1)<n && (j-1)>=0){ //travel SW
            ints[++total]=(mat[++i][--j]);
        }
        if((i+1)<n || (j+1) < n){
            total++;
            if((i+1)<n)
                ints[total]=(mat[++i][j]);
            else ints[total]=(mat[i][++j]);
            while ((i-1)>=0 && (j+1)<n){ //Mpve NE
                ints[++total]=(mat[--i][++j]);
            }
        }
        recursive(i,j,total,n,mat, ints);
    }

}
