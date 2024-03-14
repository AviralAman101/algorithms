package in.algo;

import java.util.Arrays;

/*
* Given a square matrix a of size n x n, where each cell can be either 'X' or 'O',
* you need to find the size of the largest square subgrid that is completely surrounded by 'X'.
* More formally you need to find the largest square within the grid where all its border cells are 'X'.

*
Example 1:

Input:
n = 2
a = [[X,X],
     [X,X]]
Output:
2
Explanation:
The largest square submatrix
surrounded by X is the whole
input matrix.
Example 2:

Input:
n = 4
a = [[X,X,X,O],
     [X,O,X,X],
     [X,X,X,O],
     [X,O,X,X]]
Output:
3
Explanation:
Here,the input represents following
matrix of size 4 x 4
X X X O
X O X X
X X X O
X O X X
The square submatrix starting at
(0,0) and ending at (2,2) is the
largest submatrix surrounded by X.
Therefore, size of that matrix would be 3.
*
* */
public class LargestSubSquareSurroundedByX {
    public static void main(String[] args) {
//        System.out.println(largestSubsquare(2, new char[][]{{'X','X'},
//                {'X','X'}}));
                System.out.println(largestSubsquare(3, new char[][]{{'X', 'X', 'X'},
                        {'0', 'X', 'X'},
                        {'0', 'X', '0'}}));
//        System.out.println(largestSubsquare(1, new char[][]{{'0'}}));
//        System.out.println(largestSubsquare(4, new char[][]{{'X','X','X','O'},
//                {'X','O','X','X'},
//                {'X','X','X','O'},
//                {'X','O','X','X'}}));
//        System.out.println(largestSubsquare(4, new char[][]{{'O', 'O' ,'O', 'O'},
//                {'O','X' ,'O' ,'O'},
//                {'O' ,'O', 'O', 'O'},
//                {'O' ,'O' ,'O' ,'O'}}));
//        System.out.println(largestSubsquare(4, new char[][]{{'O', 'O' ,'O', 'O'},
//                {'O','O' ,'O' ,'O'},
//                {'O' ,'O', 'O', 'O'},
//                {'O' ,'O' ,'O' ,'O'}}));
//        System.out.println(largestSubsquare(6, new char[][]{{'X', 'X', 'X', 'X', 'O', 'O'},
//                                                                {'X', 'X', 'X', 'X', 'O', 'O'},
//                                                                {'X', 'X', '0', '0', 'O', 'O'},
//                                                                {'X', 'X', '0', 'X', 'X', 'X'},
//                                                                {'0', '0', '0', 'X', 'X', 'X'},
//                                                                {'0', '0', '0', 'X', 'X', 'X'}}));
//        }));
//                System.out.println(largestSubsquare(3, new char[][]{{'X','X','X'},
//                {'X','O','X'},
//                {'X','X','X'}}));

/*  X X X X O O
    X X X X O O
    X X O O O O
    X X O X X X
    O O O X X X
    O O O X X X*/
    }
    static int largestSubsquare(int n, char a[][]) {
        // code here
        // code here
        int row[][]=new int[n][n];
        int col[][]=new int[n][n];
        //prefix sum in rows
        for(int i=0;i<n;i++){
            row[i][0]=(a[i][0]=='X'?1:0);
            for(int j=1;j<n;j++){
                if(a[i][j]=='X')
                    row[i][j]=row[i][j-1]+1;
                else
                    row[i][j]=0;
            }
        }

        //prefix sum in cols
        for(int i=0;i<n;i++){
            col[0][i]=(a[0][i]=='X'?1:0);
            for(int j=1;j<n;j++){
                if(a[j][i]=='X')
                    col[j][i]=col[j-1][i]+1;
                else
                    col[j][i]=0;
            }
        }
        int res=0;
        for(int i=n-1;i>=res;i--){
            for(int j=n-1;j>=res;j--){
                int side=Math.min(row[i][j],col[i][j]);
                while(side>res){
                    if(row[i-side+1][j]>=side && col[i][j-side+1]>=side){
                        res=side;
                        break;
                    }else{
                        side--;
                    }
                }
            }
        }
        return res;
    }
}
