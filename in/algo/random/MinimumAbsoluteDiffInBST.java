package in.algo.random;

import java.util.ArrayList;

/*
* Given a binary search tree having n (n>1) nodes, the task is to find the minimum absolute difference between any
* two nodes.

Example 1:

Input:
           50
         /    \
        30      70
       /        / \
      20      60   80
Input tree

Output:
10
Explanation:
There are no two nodes whose absolute difference is smaller than 10.
Example 2:

Input:
Input tree
           60
         /    \
        30      90
       /
      10
Output:
20
Explanation:
There are no two nodes whose absolute difference is smaller than 20.*/
public class MinimumAbsoluteDiffInBST {
    public static void main(String[] args) {
        MinimumAbsoluteDiffInBST main = new MinimumAbsoluteDiffInBST();
        int i = absolute_diff(main.init());
        System.out.println("Min diff : "+ i);
    }
    private Node init(){
        Node sixty = new Node(60);
        Node thirty = new Node(30);
        Node ten = new Node(10);
        Node ninety = new Node(90);

        sixty.left=thirty;
        sixty.right=ninety;
        thirty.left=ten;
        return sixty;
    }
    static int min = Integer.MAX_VALUE;
    static int absolute_diff(Node root)
    {
        //Your code hereHi @
        ArrayList<Integer> arr = new ArrayList<>();
        rec(root, arr);
        //System.out.println("Unsorted : " + arr);

        mergeSort(arr, 0, arr.size() - 1);
        int tn = 0;
        tn = min;
        min = Integer.MAX_VALUE;
        return tn;

    }
    private static void rec(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        rec(root.left, arr);
        arr.add(root.data);
        rec(root.right, arr);
    }
    private class Node{
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

    public static void mergeSort(ArrayList<Integer> arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start+ end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

        private static void merge(ArrayList<Integer> arr, int start, int mid, int end) {
        int i= start;
        int j= mid+1;
        ArrayList<Integer> as = new ArrayList<>();
        while (i<=mid && j<= end){
            Integer t = arr.get(i);
            Integer r = arr.get(j);
            if(t > r){
                if(t-r < min){
                    min = t-r;
                }
                as.add(r);
                j++;
            }
            if(t < r){
                if(r-t < min){
                    min = r-t;
                }
                as.add(t);
                i++;
            }
            if(t == r){
                min=0;
                as.add(t);
                i++;
            }
        }

        while (i<=mid){
            as.add(arr.get(i));
            i++;
        }
        while (j<=end){
            as.add(arr.get(j));
            j++;
        }
        for (int k = 0; k < as.size(); k++) {
            arr.set(start, as.get(k));
            start++;
        }
    }


}
