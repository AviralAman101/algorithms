package in.algo.random;

/*
* Given the root of a binary search tree and a number n, find the greatest number in the binary search tree that is less than or equal to n.

Example 1 :

Input:
           5
         /    \
        2      12
       / \      / \
      1   3    9   21
                   / \
                  19  25

n = 24
Output :
21
Explanation : The greatest element in the tree which
              is less than or equal to 24, is 21.
              (Searching will be like 5->12->21)
Example 2 :

Input:
           5
         /    \
        2      12
       / \      / \
      1   3    9   21
                   / \
                  19  25

n = 4
Output :
3
Explanation : The greatest element in the tree which
              is less than or equal to 4, is 3.
              (Searching will be like 5->2->3)*/
public class ClosestNeighbourInBST {
    private class Node{
        int key;
        Node left, right;

        Node(int x)
        {
            key = x;
            left = right = null;
        }

    }
    public static void main(String[] args) {

    }
    public static int findMaxForN(Node root, int n) {
        // Add your code here.
        int ele = 0;
        if(root.key <= n){
            ele = root.key;
        }
        int left=Integer.MAX_VALUE;
        if(root.left != null){
            left = findMaxForN(root.left, n);
        }
        int right=Integer.MAX_VALUE;
        if(root.right != null){
            right = findMaxForN(root.right, n);
        }
        if(left<= n && n-left < n- ele){
            ele = left;
        }
        if(right<= n && n-right < n- ele){
            ele = right;
        }
        if(ele == 0) ele=-1;
        return ele;

    }
}
