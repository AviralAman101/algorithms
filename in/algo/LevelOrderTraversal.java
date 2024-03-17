package in.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
* Given a root of a binary tree with n nodes, find its level order traversal.
Level order traversal of a tree is breadth-first traversal for the tree.

Example 1:

Input:
    1
  /   \
 3     2
Output:
1 3 2
Example 2:

Input:
        10
     /      \
    20       30
  /   \
 40   60
Output:
10 20 30 40 60
* */
public class LevelOrderTraversal {
    public static void main(String[] args) {

    }
    private class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    //Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node root)
    {
        // Your code here
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(root.data);
        queue.add(root);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            result.add(poll.data);
            if(poll.left != null)
            queue.add(poll.left);
            if(poll.right != null)
            queue.add(poll.right);
        }
        return result;
    }
}
