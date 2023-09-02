package in.algo.bst;

import java.util.Objects;

public class BSTPringHeight {

    private static class node{
        int key;
        node left, right;
    }

    static node newNode(int key){
        node node = new node();
        node.key = key;
        return node;
    }

    private static node insert(node root, int key){
        if(Objects.isNull(root))
            return newNode(key);

        if(key < root.key){
            root.left = insert(root.left, key);
        }
        if(key > root.key){
            root.right = insert(root.right, key);
        }

        return root;
    }

    public static void main(String[] args) {
        node root = null;
        root = insert(root, 80);
        insert(root, 90);
        insert(root, 70);
        insert(root, 60);
        insert(root, 100);

        System.out.println(printHeight(root));
    }

    private static int printHeight(node root) {
        if(Objects.isNull(root))
            return 0;
        int rightHeight=printHeight(root.right);
        int leftHeight=printHeight(root.left);

        if(rightHeight > leftHeight)
            return rightHeight+1;
        else
            return leftHeight+1;
    }
}
