package in.algo;

import java.util.ArrayList;
import java.util.Objects;

public class TrieNodeMatrixSearch {
    /*
    Given a boolean matrix of size RxC where each cell contains either 0 or 1, find the row numbers (0-based) of
    row which already exists or are repeated.

Example 1:

Input:
R = 2, C = 2
matrix[][] = {{1, 0},
            {1, 0}}
Output:
1
Explanation:
Row 1 is duplicate of Row 0.
Example 2:

Input:
R = 4, C = 3
matrix[][] = {{ 1, 0, 0},
            { 1, 0, 0},
            { 0, 0, 0},
            { 0, 0, 0}}
Output:
1 3
Explanation:
Row 1 and Row 3 are duplicates of Row 0 and 2 respectively.
Your Task:
You don't need to read input or print anything. Complete the function repeatedRows() that takes the
matrix as input parameter and returns a list of row numbers which are duplicate rows.
*/
    public static void main(String[] args) {
       int matrix[][] = {{ 1, 0, 0},
            { 1, 0, 0},
            { 0, 0, 0},
            { 0, 0, 0}};
        System.out.println(findRepeatedRows(matrix, 4, 3));
    }
    /* Trie Node */
    static class Trie {
        boolean leaf;
        Trie[] children;

        Trie() {
            children = new Trie[2];
            leaf = false;
        }
    }

    static boolean insertAndCheck(Trie head, int[] row, int coulmns){
        Trie current = head;
        for (int i = 0; i < coulmns; i++) {
            if(Objects.isNull(current.children[row[i]])){
                current.children[row[i]]=new Trie();
            }
            current = current.children[row[i]];
        }
        /* If the row already exists, return false */
        if(current.leaf)
            return false;

        return current.leaf=true;
    }

    static ArrayList<Integer> findRepeatedRows(int[][] matrix, int rows, int columns){
        Trie head = new Trie();
        ArrayList<Integer> rowNums = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            // Checks if row already exists otherwise inserts
            if(!insertAndCheck(head, matrix[i], columns))
                rowNums.add(i);
        }
        return rowNums;
    }

}
