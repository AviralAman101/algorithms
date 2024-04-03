package in.algo.random;

import java.util.ArrayList;
import java.util.Collections;

/*
* Given a BST with n (n>=2) nodes, find the kth common ancestor of nodes x and y in the given tree.
* Return -1 if kth ancestor does not exist.

Nodes x and y will always be present in the input of a BST, and x != y.

Example 1:

Input:
Input tree

k = 2, x = 40, y = 60
Output:
30
Explanation:
Their 2nd common ancestor is 30.
Example 2:

Input:
Input tree

k = 2, x = 40, y = 60
Output:
-1
Explanation:
LCA of 40 and 60 is 50, which is root itself. There does not exists 2nd common ancestor in this case.*/
public class KthCommonAncestorBST {
    private class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {

    }

    Node LCA(Node root, int x, int y) {
        if (root == null) return null;

        if (x < root.data && y < root.data) return LCA(root.left, x, y);

        if (x > root.data && y > root.data) return LCA(root.right, x, y);

        return root;
    }

    void pathToNode(Node root, Node node, ArrayList<Integer> path) {
        path.add(root.data);

        if (root.data == node.data)
            return;
        else if (node.data > root.data)
            pathToNode(root.right, node, path);
        else
            pathToNode(root.left, node, path);
    }

    public int kthCommonAncestor(Node root, int k, int x, int y) {
        Node lca = LCA(root, x, y);
        ArrayList<Integer> path = new ArrayList<Integer>();
        pathToNode(root, lca, path);
        Collections.reverse(path); // equivalent of reverse method in C++

        if (path.size() < k) return -1;

        return path.get(k - 1); // equivalent of path[k-1] in C++
    }
}
