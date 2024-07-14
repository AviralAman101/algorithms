package in.algo.amazon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
* Given a binary tree and an integer target, check whether there is a root-to-leaf path with its sum as target.

Examples :

Input: tree = 1, target = 2
            /   \
          2     3
Output: false
Explanation: There is no root to leaf path with sum 2.
Input: tree = 1,  target = 4
            /   \
          2     3
Output: true
Explanation: The sum of path from leaf node 3 to root 1 is 4.
* */
public class RootPathSum {
    public static void main(String[] args) {
        System.out.println(hasPathSum(init(), 2));
        System.out.println(hasPathSum(init(), 3));
        System.out.println(hasPathSum(init(), 4));
    }

    private static Node init(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.left = n2;
        n1.right = n3;
        return n1;
    }

    private static boolean hasPathSum(Node root, int target) {
        // Your code here
        return dfs(root, target);
    }

    private static boolean dfs(Node root, int target) {
        if(root.data == target && root.left==null && root.right == null) return true;
        target = target -root.data;
        if(target<0) return false;
        boolean left = false;
        boolean right = false;

        if(root.left != null)
            left= dfs(root.left, target);
        if(root.right != null)
            right = dfs(root.right, target);
        return left || right;
    }

    private static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
}
