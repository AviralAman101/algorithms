package in.algo.random;

/*Given the root of a Binary Search Tree. The task is to find the minimum valued element in this given BST.

Example 1:

Input:
           5
         /    \
        4      6
       /        \
      3          7
     /
    1
Output: 1
Example 2:

Input:
             9
              \
               10
                \
                 11
Output: 9
* */
public class MinElementInBST {
    private class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        System.out.println(minValue(new MinElementInBST().init()));
    }
    private Node init(){
        Node node = new Node(5);
        Node four = new Node(4);
        Node six = new Node(6);
        Node three = new Node(3);
        Node seven = new Node(7);
        Node one = new Node(1);
        three.left=one;
        four.left=three;
        six.right=seven;
        node.left=four;
        node.right=six;
        return node;
    }
    static int minValue(Node root) {
        // code here
        int min;
        if(root == null) return -1;
        else min= root.data;
        int left=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;
        if(root.left != null){
            left = minValue(root.left);
        }
        if(root.right != null){
            right = minValue(root.right);
        }
        if(min > left) min = left;
        if(min > right) min = right;
        return min;
    }


}
