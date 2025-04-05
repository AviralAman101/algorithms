package in.algo.sp2025;


/*
* Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.

Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Examples:

Input: grid[][] = [['L', 'L', 'W', 'W', 'W'], ['W', 'L', 'W', 'W', 'L'], ['L', 'W', 'W', 'L', 'L'], ['W', 'W', 'W', 'W', 'W'], ['L', 'W', 'L', 'L', 'W']]
Output: 4
Explanation:
The image below shows all the 4 islands in the grid.

Input: grid[][] = [['W', 'L', 'L', 'L', 'W', 'W', 'W'], ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
Output: 2
Expanation:
The image below shows 2 islands in the grid.

Constraints:
1 ≤ n, m ≤ 500
grid[i][j] = {'L', 'W'}
* */
public class FindIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'W', 'L', 'L', 'L', 'W', 'W', 'W'},
                {'W', 'W', 'L', 'L', 'W', 'L', 'W'}};
        //System.out.println(countIslands(grid));
        /*
        * 4
        2
        W L
        L W
        L L
        L W*/
        grid = new char[][]{{'W','L'},{'L','W'},{'L','L'},{'L', 'W'}};
        //System.out.println(countIslands(grid));
        /*5
4
L W L L
W L W L
L L W L
W W L L
L L L L*/
        grid = new char[][]{{'L','W','L','L'},
                {'W','L','W','L'},
                {'L','L','W','L'},
                {'W','W','L','L'},
                {'L','L','L','L'}};

        System.out.println(countIslands(grid));

    }

    public static int countIslands(char[][] grid) {
        // Code here
        int c= 0;
        int len2 = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < len2; j++) {
                if(grid[i][j] == 'L') {
                    c++;
                    dfsMarkAllLands(i, j, grid);
                }
            }
        }
        return c;
    }

    private static boolean dfsMarkAllLands(int i, int j, char[][] grid) {
        if( i<0 || j<0 || i == grid.length || j == grid[i].length) return false;
        if(grid[i][j] == 'L') {
            grid[i][j] = 'X';
            dfsMarkAllLands(i-1, j-1, grid); //
            dfsMarkAllLands(i+1, j, grid); //
            dfsMarkAllLands(i, j+1, grid); //
            dfsMarkAllLands(i+1, j-1, grid); //
            dfsMarkAllLands(i+1, j+1, grid); //
            dfsMarkAllLands(i-1, j+1, grid); //
            dfsMarkAllLands(i-1, j, grid); //
            dfsMarkAllLands(i, j-1, grid); //
        }
        return false;
    }
}
