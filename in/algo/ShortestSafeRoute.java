package in.algo;

/*
* Given a matrix mat[][] with r rows and c columns, where some cells are landmines
* (marked as 0) and others are safe to traverse. Your task is to find the shortest
* safe route from any cell in the leftmost column to any cell in the rightmost column
* of the mat. You cannot move diagonally, and you must avoid both the landmines and
* their adjacent cells (up, down, left, right), as they are also unsafe.

Example 1:

Input:
mat = [1, 0, 1, 1, 1],
      [1, 1, 1, 1, 1],
      [1, 1, 1, 1, 1],
      [1, 1, 1, 0, 1],
      [1, 1, 1, 1, 0]
Output:
6
Explanation:
We can see that length of shortest
safe route is 6
[1 0 1 1 1]
[1 1 1 1 1]
[1 1 1 1 1]
[1 1 1 0 1]
[1 1 1 1 0]
Example 2:

Input:
mat = [1, 1, 1, 1, 1],
      [1, 1, 0, 1, 1],
      [1, 1, 1, 1, 1]
Output:
-1
Explanation: There is no possible path from
first column to last column.
* */
public class ShortestSafeRoute {
    public static void main(String[] args) {
        int [][] mat = {{1, 0, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 1, 1, 0, 1},
    {1, 1, 1, 1, 0}};
        System.out.println(findShortestPath(mat));
    }

    public static int findShortestPath(int[][] mat) {
        // code here
        int min =-1;
        for (int rw = 0; rw < mat.length; rw++) {

        }
        return min;
    }



    private static boolean isSafe(int i, int j, int[][]mat, boolean[][] path){
        int rowLen = mat.length;
        int colLen = mat[0].length;
        if(i <0 || i>= rowLen) return false;
        if(j <0 || j>= colLen) return false;
        if(mat[i][j]==0) return false;
        if(path[i][j]) return false;
        if(i+1 < rowLen && mat[i+1][j] ==0){
            return false;
        }
        if(i-1 > -1 && mat[i-1][j] ==0){
            return false;
        }
        if(j+1 > colLen && mat[i][j+1] ==0){
            return false;
        }
        return true;
    }
}
