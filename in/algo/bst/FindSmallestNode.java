package in.algo.bst;

import java.util.Objects;

public class FindSmallestNode {
    private static class node{
        int key;
        node left, right;
    }

    private static node getNewNode(int key){
        node node = new node();
        node.key = key;
        return node;
    }

    private static node insert(node root, int key){
        if(Objects.isNull(root))
            return getNewNode(key);

        if(key < root.key)
            root.left = insert(root.left, key);

        if(key > root.key)
            root.right = insert(root.right, key);

        return root;
    }

    private static node getSmallestNode(node root){
        node current = root;
        while (!Objects.isNull(current) && current.left != null)
            current = current.left;
        return current;
    }
}
