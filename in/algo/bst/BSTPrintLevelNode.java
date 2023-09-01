package in.algo.bst;

import java.util.Objects;

public class BSTPrintLevelNode {
    private static class node{
        int key;
        node left, right;
    };
    // Function to create a new BST node
    static node newNode(int item)
    {
        node temp = new node();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }
    private static node insert(node node, int key){
        if(Objects.isNull(node))
            return newNode(key);
        if(key < node.key)
            node.left = insert(node.left, key);
        if(key > node.key)
            node.right = insert(node.right, key);
        return node;
    }

    private static void printGivenLevel(node node, int level){
        if(Objects.isNull(node))
            return;
        if(level == 1)
            System.out.println(node.key);
        else{
            printGivenLevel(node.left, level-1);
            printGivenLevel(node.right, level-1);
        }
    }

    public static void main(String[] args) {
        node root = null;
        root = insert(root, 80);
        insert(root, 90);
        insert(root, 70);
        insert(root, 60);
        insert(root, 100);

        printGivenLevel(root, 2);
    }
}
