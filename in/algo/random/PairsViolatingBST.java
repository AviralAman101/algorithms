package in.algo.random;

import java.util.ArrayList;

/*

* Given a binary tree with n nodes, find the number of pairs violating the BST property.
BST has the following properties:-

Every node is greater than its left child and less than its right child.
Every node is greater than the maximum value of in its left subtree and less than the minimum value in its right subtree.
The maximum in the left sub-tree must be less than the minimum in the right subtree.
Example 1:

Input:
           10
         /    \
        50      40
       / \      / \
               20   30
n = 5
Input tree

Output :
5
Explanation :
Pairs violating BST property are:-
(10,50), 10 should be greater than its left child value.
(40,30), 40 should be less than its right child value.
(50,20), (50,30) and (50,40), maximum of left subtree of 10 is 50 greater than 20, 30 and 40 of its right subtree.
Example 2:

Input:
           80
         /    \
        40      30
       /        / \
      70      60   70
n = 6
Input tree

Output :
5
Explanation :
Pairs violating BST property are:-
(80,30), greater than its right child.
(80,60), greater than node on its right side.
(80,70), greater than node on its right side.
(30,60), the value of 3 is not more than its left child.
(40,30), the value in the left subtree is greater than the value of the right subtree.*/
public class PairsViolatingBST {
    public static void main(String[] args) {
        PairsViolatingBST pairsViolatingBST = new PairsViolatingBST();
        PairsViolatingBST.Solution s =new Solution();
        int i = Solution.pairsViolatingBST(6, pairsViolatingBST.init());
        System.out.println(i);


    }
    private Node init(){
        Node eighty = new Node(80);
        Node forty = new Node(40);
        Node thirty = new Node(30);
        Node seventy = new Node(70);
        Node sixty = new Node(60);
        Node seventy2 = new Node(70);

        forty.left=seventy;
        eighty.left=forty;
        eighty.right=thirty;
        thirty.left=sixty;
        thirty.right=seventy2;
        return eighty;
    }
    private class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
//    private Node init(){
//
//    }
    public static int pairsViolatingBST(int n, Node root) {
        // code here

        return -1;
    }

    private static class Solution {
        public static void mergeSort(ArrayList<Integer> arr, int start, int end) {
            if (start >= end) {
                return;
            }
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }

        static int count = 0;

        public static void merge(ArrayList<Integer> arr, int start, int mid, int end) {
            int i = start;
            int j = mid + 1;
            ArrayList<Integer> as = new ArrayList<>();
            // int t=0;
            while (i <= mid && j <= end) {
                int t = arr.get(i);
                int r = arr.get(j);
                if (t > r) {
                    as.add(r);
                    j++;
                    int k = mid + 1;
                    count = count + (k - i);
                }
                if (t < r) {
                    as.add(t);
                    i++;
                }

                if (t == r) {
                    as.add(t);
                    i++;
                }
            }

            while (i <= mid) {
                as.add(arr.get(i));
                i++;
            }

            while (j <= end) {
                as.add(arr.get(j));
                j++; // count++;
            }

            for (int k = 0; k < as.size(); k++) {
                arr.set(start, as.get(k));
                start++;
            }
            System.out.println("List : " + arr);
        }

        public static void rec(Node root, ArrayList<Integer> arr) {
            if (root == null) {
                return;
            }

            rec(root.left, arr);
            arr.add(root.data);
            rec(root.right, arr);
        }

        public static int pairsViolatingBST(int n, Node root) {
            ArrayList<Integer> arr = new ArrayList<>();
            rec(root, arr);
            System.out.println("Unsorted : " + arr);
            mergeSort(arr, 0, arr.size() - 1);
            System.out.println("Sorted : " + arr);
            int tn = 0;
            tn = count;
            count = 0;
            return tn;
        }
    }
}
