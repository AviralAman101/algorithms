package in.algo.amazon;


import java.util.ArrayList;
import java.util.Collections;

/*

* Given an array parent that is used to represent a tree.
* The array indices (0-based indexing) are the values of the tree nodes
* and parent[i] denotes the parent node of a particular node.
* The parent of the root node would always be -1, as there is no parent for the root.
* Construct the standard linked representation of Binary Tree from this
* array representation and return the root node of the constructed tree.

Note: If two elements have the same parent, the one that appears
* first in the array will be the left child and the other is the right child.
* You don't need to print anything, the driver code will print the level order
* traversal of the returned root node to verify the output.


Examples:

Input: parent[] = [-1, 0, 0, 1, 1, 3,5]
Output: 0 1 2 3 4 5 6
Explanation: the tree generated
will have a structure like
          0
        /   \
       1     2
      / \
     3   4
    /
   5
 /
6

Input: parent[] = [2, 0, -1]
Output: 2 0 1
Explanation: the tree generated will
have a structure like
             2
            /
           0
          /
         1

* */
public class CreateTree {
    public static void main(String[] args) {
        createTree(new int[]{-1, 0, 0, 1, 1, 3,5});
        printLevelOrder(root);
        //System.out.println();
    }

    static Node root;

    // Function to construct binary tree from parent array.
    private static Node createTree(int arr[]) {
        root = null;
        int n = arr.length;
        // creating an array created[] to keep track of created nodes,
        // initializing all entries as NULL.
        Node[] created = new Node[n];

        for (int i = 0; i < n; i++) createNode(arr, i, created);

        // returning root of created tree.
        return root;
    }

    // Function to create nodes.
    private static void createNode(int arr[], int i, Node created[]) {
        // base case if this node is already created.
        if (created[i] != null) return;

        // creating a new node and setting created[i].
        created[i] = new Node(i);

        // if 'i' is root, changing root pointer.
        if (arr[i] == -1) {
            root = created[i];
            return;
        }

        // if parent is not created then we create parent first.
        if (created[arr[i]] == null) createNode(arr, arr[i], created);

        // finding parent pointer.
        Node p = created[arr[i]];

        // if this is first child of parent, we store it as left child.
        if (p.left == null) p.left = created[i];
            // else we store it as right child.
        else
            p.right = created[i];
    }

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Driver Code ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


    private static class Node
    {
        int data;
        Node left, right;
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }
    static ArrayList<Integer> result = new ArrayList<Integer>();


    public static void printLevelOrder(Node root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            result.clear();
            printGivenLevel(root, i);
            Collections.sort(result);
            for (int j = 0; j < result.size(); j++)
                System.out.print(result.get(j) + " ");
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;

        else {

            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    public static void printGivenLevel(Node node, int level) {
        if (node == null) return;
        if (level == 1)
            result.add(node.data);
        else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }
}
