package in.algo.random;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* Given a binary tree having n nodes. Find the sum of all nodes on the longest path from root to any leaf node.
* If two or more paths compete for the longest path, then the path having maximum sum of nodes will be considered.

Example 1:

Input:
        4
       /  \
      2   5
     / \   /  \
    7  1 2  3
      /
     6
Output:
13
Explanation:
        4
       /  \
      2   5
     / \   /  \
    7  1 2  3
      /
     6
The highlighted nodes (4, 2, 1, 6) above are part of the longest root to leaf path having sum = (4 + 2 + 1 + 6) = 13
Example 2:

Input:
          1
        /   \
       2    3
      / \    /  \
     4   5 6   7
Output:
11
Explanation:
Use path 1->3->7, with sum 11.*/
public class SumOfLongestPathInTree {
    public static void main(String[] args) {
        Node init = new SumOfLongestPathInTree().init();
        Node init1 = new SumOfLongestPathInTree().init1();
        System.out.println(init);
        System.out.println(Arrays.toString(maxDepth(init)));
        System.out.println(Arrays.toString(maxDepth(init1)));
    }
    private Node init1(){
        /*1
        /   \
       2    3
      / \    /  \
     4   5 6   7*/
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        one.left=two;
        one.right=three;
        two.left=four;
        two.right=five;
        three.left=six;
        three.right=seven;
        return one;
    }
    private Node init(){
        Node four = new Node(4);
        Node two = new Node(2);
        Node five = new Node(5);
        Node seven = new Node(7);
        Node one = new Node(1);
        Node two2 = new Node(2);
        Node three = new Node(3);
        Node six = new Node(6);

        four.left=two;
        two.left=seven;
        two.right=one;
        //one.left=six;
        four.right=five;
        five.left=two2;
        five.right=three;
        return four;
    }
    /*
    *  4
       /  \
      2   5
     / \   /  \
    7  1 2  3
      /
     6*/
    private class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here
        return maxDepth(root)[1];
    }

    private static int[] maxDepth(Node node){
        if(node==null) return null;
        int[] left= maxDepth(node.left);
        int[] right = maxDepth(node.right);
        if(left==null && right==null){
            return new int[]{1, node.data};
        }
        if(left==null){
                right[0]++;
                right[1]=right[1]+ node.data;
                return right;

        }
        if(right==null){
            left[0]++;
            left[1]=left[1]+node.data;
            return left;
        }
        if(left[0]>=right[0]){
            if(left[0]==right[0] && left[1]<=right[1]){
                right[0]++;
                right[1]=right[1]+ node.data;
                return right;
            }
            left[0]++;
            left[1]=left[1]+node.data;
            return left;
        }else
            {
                right[0]++;
                right[1] = right[1] + node.data;
                return right;
            }
    }

    private static void check(){
        int[] a = new int[2];
        for (int i = 0; i < 5; i++) {
            a[0]++;
            a[1]++;

        }
        System.out.println(Arrays.toString(a));
    }
}
