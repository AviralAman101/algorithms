package in.algo.bst;


import java.util.Objects;

//Write a program to insert nodes in a BST
public class BinaryTreeInsert {
    private static class node {
        int key;
        node left, right;
    };
    public static void main(String[] args) {

        node root = null;
        root = insert(root, 80);
        insert(root, 90);
        insert(root, 70);
        insert(root, 60);
        insert(root, 100);

        inorder(root);
    }

    // Function to create a new BST node
    static node newNode(int item)
    {
        node temp = new node();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }
    // Function to insert a new node with
    // given key in BST
    static node insert(node node, int key)
    {
        if(Objects.isNull(node)){
            return newNode(key);
        }

        if(key < node.key)
            node.left = insert(node.left, key);
        if(key > node.key)
            node.right = insert(node.right, key);

        return node;
    }

    // Function to do inorder traversal of BST
    static void inorder(node root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.print(" " + root.key);
            inorder(root.right);
        }
    }
}
