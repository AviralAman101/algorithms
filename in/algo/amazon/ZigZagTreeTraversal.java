package in.algo.amazon;

import java.util.*;

/*
* Given a binary tree with n nodes. Find the zig-zag level order traversal of the binary tree.

Example 1:

Input:
        1
      /   \
     2    3
    / \    /   \
   4   5 6   7
Output:
1 3 2 4 5 6 7
Example 2:

Input:
           7
        /     \
       9      7
     /  \      /
    8   8  6
   /  \
  10  9
Output:
7 7 9 8 8 6 9 10 */
public class ZigZagTreeTraversal {
    public static void main(String[] args) {
        System.out.println(zigZagTraversal(new ZigZagTreeTraversal().init()));
        System.out.println(zigZagTraversal(new ZigZagTreeTraversal().init1()));

    }
    private Node init(){
        /*1
      /   \
     2    3
    / \    /   \
   4   5 6   7*/
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        root.left=two;
        root.right=three;
        two.left=four;
        two.right=five;
        three.left=six;
        three.right=seven;
        return root;
    }
    private Node init1(){
        /*  7
        /     \
       9      7
     /  \      /
    8   8  6
   /  \
  10  9*/
        Node root = new Node(7);
        Node nine = new Node(9);
        Node seven = new Node(7);
        Node eight0 = new Node(8);
        Node eight1 = new Node(8);
        Node six = new Node(6);
        Node ten = new Node(10);
        Node nine1 = new Node(9);
        root.left=nine;
        root.right=seven;
        nine.left=eight0;
        nine.right=eight1;
        eight0.left=ten;
        eight0.right=nine1;
        seven.left=six;
        return root;

    }
    private class Node
    {
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }
    static ArrayList<Integer> zigZagTraversal(Node root)
    {
        //Add your code here.
       /*1
      /   \
     2    3
    / \    /   \
   4   5 6   7*/
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        myFunction(stack, true, result);
        return result;
    }
    private static void myFunction(Stack<Node> stack, boolean travelRight, ArrayList<Integer> res){
        Stack<Node> stk = new Stack<>();
        if(!travelRight){
            while (!stack.isEmpty()){
                Node pop = stack.pop();
                res.add(pop.data);
                Node right = pop.right;
                Node left = pop.left;
                if(Objects.nonNull(right))
                    stk.add(right);
                if(Objects.nonNull(left))
                    stk.add(left);
            }
        }else {
            while (!stack.isEmpty()){
                Node pop = stack.pop();
                res.add(pop.data);
                Node right = pop.right;
                Node left = pop.left;
                if(Objects.nonNull(left))
                    stk.add(left);
                if(Objects.nonNull(right))
                    stk.add(right);
            }
        }if(!stk.isEmpty())
        myFunction(stk, !travelRight, res);
    }

}
