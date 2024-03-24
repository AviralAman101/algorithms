package in.algo.amazon;


import java.util.*;
import java.util.stream.Collectors;

/*
* Consider Red lines of slope -1 passing between nodes (in following diagram).
* The diagonal sum in a binary tree is the sum of all node datas lying between these lines.
* Given a Binary Tree of size n, print all diagonal sums.

For the following input tree, output should be 9, 19, 42.
9 is sum of 1, 3 and 5.
19 is sum of 2, 6, 4 and 7.
42 is sum of 9, 10, 11 and 12.

DiagonalSum

Example 1:

Input:
         4
       /   \
      1     3
           /
          3
Output:
7 4
Example 2:

Input:
           10
         /    \
        8      2
       / \    /
      3   5  2
Output:
12 15 3 */
public class DaigonalSumOfBinaryTree {
    private class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        System.out.println(diagonalSum(new DaigonalSumOfBinaryTree().init0()));
    }
    private Node init0(){
        /*
*          4
       /   \
      1     3
           /
          3*/
        Node root = new Node(4);
        Node three = new Node(3);
        Node one = new Node(1);
        Node three1 = new Node(3);
        root.left=one;
        root.right=three;
        three.left=three1;
        return root;
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
    public static ArrayList<Integer> diagonalSum(Node root)
    {
        // code here.
        HashMap<Integer, Integer> slopeWeight = new HashMap<>();
        diagonal(root, 0, slopeWeight);
       // System.out.println(slopeWeight);
        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry :slopeWeight.entrySet()){
            res.add(entry.getValue());
        }
        //return slopeWeight.entrySet().stream().map(s -> s.getValue()).collect(Collectors.toCollection(ArrayList::new));
        return res;
    }

    private static void diagonal(Node node, int slope, HashMap<Integer, Integer> slopeWeight){
        if (Objects.isNull(node))
            return;
        Integer weight = slopeWeight.get(slope);
        if (weight != null)
        slopeWeight.put(slope, node.data+weight);
        else slopeWeight.put(slope, node.data);
        diagonal(node.right, slope,slopeWeight);
        //System.out.println("right");
        diagonal(node.left, slope+1,slopeWeight);
    }
}
