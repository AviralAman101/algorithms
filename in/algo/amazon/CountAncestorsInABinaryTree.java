package in.algo.amazon;


import java.util.ArrayList;

/*
* Given a Binary Tree and an integer target. Find all the ancestors of the given target.

Note:

The ancestor of node x is node y, which is at the upper level of node x,
* and x is directly connected with node y. Consider multiple levels of ancestors to solve this problem.
In case there are no ancestors available, return an empty list.
Examples:

Input:
         1
       /   \
      2     3
    /  \    /  \
   4   5  6   8
  /
 7
target = 7
Output: [4 2 1]
Explanation: The given target is 7, if we go above the level of node 7,
* then we find 4, 2 and 1. Hence the ancestors of node 7 are 4 2 and 1
Input:
        1
      /   \
     2     3
target = 1
Output: [ ]
Explanation: Since 1 is the root node, there would be no ancestors. Hence we return an empty list.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(height of tree)

Constraints:
1 ≤ no. of nodes ≤ 103
1 ≤ data of node ≤ 104
*
* */
public class CountAncestorsInABinaryTree {

    public static void main(String[] args) {
        System.out.println(Ancestors(init(), 7));
    }

    public static ArrayList<Integer> Ancestors(Node root, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        String dfs = dfs(root, target, "");
        if(dfs.contains("-1") || dfs.length() == 1)
            return res;

//        System.out.println(dfs);
        String[] split = dfs.split(",");
        for (int i = split.length-2; i >= 0 ; i--) {
            res.add(Integer.parseInt(split[i]));
        }
        return res;
    }

    private static Node init() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(7);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n7;
        n3.left = n6;
        n3.right = n8;
        return n1;
    }
    /*
*         1
       /    \
      2      3
    /  \    /  \
   4    5  6    8
  /
 7*/

    private static String dfs(Node current, int target, String res) {
        if(current == null) return "-1";
        if(current.data == target) return "#";
        String left = current.left != null ? (current.data +","+ dfs(current.left, target, res)) : "-1";
        String right = current.right != null ? (current.data+ "," + dfs(current.right, target, res)) : "-1";
        if(left.contains("-1") && right.contains("-1")) return "-1";
        if(!left.contains("-1") && !right.contains("-1")) return left.length() < right.length() ? left :right;
        if(left.contains("-1")) return right;
        if(right.contains("-1")) return left;
        return "-1";
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
