package in.algo.amazon;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
*
* Given a Linked List Representation of Complete Binary Tree.
* The task is to construct the Binary tree and print the level
* order traversal of the Binary tree.
Note: The complete binary tree is represented as a linked list
* in a way where if the root node is stored at position i,
* its left, and right children are stored at position 2*i+1,
* and 2*i+2 respectively. H is the height of the tree and this
* space is used implicitly for the recursion stack.

Examples:

Input: n = 5, k = 1->2->3->4->5
Output: 1 2 3 4 5
Explanation: The tree would look like
      1
    /   \
   2     3
 /  \
4   5
Now, the level order traversal of
the above tree is 1 2 3 4 5.

Input: n = 5, k = 5->4->3->2->1
Output: 5 4 3 2 1
Explanation: The tree would look like
     5
   /  \
  4    3
 / \
2   1
Now, the level order traversal of
the above tree is 5 4 3 2 1.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).
Constraints:
1 <= n <= 105
1 <= ki <= 105
*
* */
public class MakeBinaryTreeFromLinkedList {

    public static void main(String[] args) {
        Tree tree = convert(getNode(), null);
        levelOrder(tree, 5);
    }

    private static Tree convert(Node root, Tree node) {
        ArrayList<Tree> nodes = new ArrayList<>();
        int i=0;
        node = new Tree(root.data);
        nodes.add(node);
        boolean leftNode = true;
        while (root.next != null){
            root = root.next;
            if(leftNode){
                Tree left = new Tree(root.data);
                nodes.add(left);
                nodes.get(i).left = left;
            } else {
                Tree right = new Tree(root.data);
                nodes.add(right);
                nodes.get(i).right = right;
                i++;
            }
            leftNode = !leftNode;
        }
        return node;
    }

    public static Tree convertUsingQueue(Node head, Tree node)
    {
        if (head == null) {
            return null;
        }
        node = new Tree(head.data);
        Tree curr = node;
        head = head.next;
        Queue<Tree> q = new LinkedList<>();
        q.add(curr);
        while (head != null) {
            Tree current = q.poll();
            Tree left = new Tree(head.data);
            current.left = left;
            q.add(left);
            head = head.next;
            if(head != null)
            {
                Tree right = new Tree(head.data);
                current.right = right;
                q.add(right);
                head = head.next;
            }
        }
        return node;
    }

    private static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    private static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int d){
            data=d;
            left=null;
            right=null;
        }
    }
    static Queue<Tree> queue = new LinkedList<Tree>();

    public static void levelOrder(Tree root, int n) {
        queue.add(root);
        while (!queue.isEmpty() && n-- > 0) {
            Tree proot = queue.remove();
            try {
                queue.add(proot.left);
                queue.add(proot.right);
                System.out.print(proot.data + " ");
            } catch (NullPointerException ex) {
            }
        }
    }

    private static Node getNode(){
        Node n1 = new Node(5);
        Node n2 = new Node(4);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }
}
