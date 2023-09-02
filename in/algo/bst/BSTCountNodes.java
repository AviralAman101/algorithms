package in.algo.bst;

public class BSTCountNodes {
    private static class node{
        int key;
        node left, right;
    }

    private static node insert(node root, int key){
        if(root == null){
            return getNewNode(key);
        }

        if(key < root.key)
            root.left = insert(root.left, key);
        if(key > root.key)
            root.right = insert(root.right, key);

        return root;
    }

    private static node getNewNode(int key) {
        node node = new node();
        node.key = key;
        return node;
    }

    private static long getNodeCount(node root){
        if(root == null)
            return 0;
        long nodeCountLeft =0, nodeCountRight=0;
        if(root.left != null) {
            nodeCountLeft = getNodeCount(root.left);
        }
        if(root.right != null){
            nodeCountRight = getNodeCount(root.right);
        }
        return nodeCountLeft+nodeCountRight+1;
    }

    public static void main(String[] args) {
        node root = null;
        root = insert(root, 80);
        insert(root, 90);
        insert(root, 70);
        insert(root, 60);
        insert(root, 100);

        System.out.println(getNodeCount(root));
    }
}
