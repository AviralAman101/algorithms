package in.algo;


//Given two linked lists of size N and M, which are sorted in non-decreasing order.
// The task is to merge them in such a way that the resulting list is in non-increasing order.
/*
* Input:
N = 2, M = 2
list1 = 1->3
list2 = 2->4
Output:
4->3->2->1
Explanation:
After merging the two lists in non-increasing order, we have new lists as 4->3->2->1.
*
* Input:
N = 4, M = 3
list1 = 5->10->15->40
list2 = 2->3->20
Output:
40->20->15->10->5->3->2
Explanation:
After merging the two lists in non-increasing order, we have new lists as 40->20->15->10->5->3->2.
*
* */
public class MergeResults {
    static class Node
    {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }

        @Override
        public String toString() {
            return this.data + "," + next;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        Node next10 = new Node(10);
        Node node15 = new Node(15);
        Node node20 = new Node(40);
        node15.next = node20;
        next10.next = node15;
        node.next = next10;

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node201 = new Node(20);
        node3.next = node201;
        node2.next = node3;
        // Node 1 = 5,10,15,40  Node2 = 2,3,20
        Node node1 = new MergeResults().mergeResult(node, node2);

        //Merged Result = 40,20,15,10,5,3,2
        System.out.println(node1);

    }
    Node mergeResult(Node node1, Node node2)
    {
        // Your code here
        Node node = null;
        while (node1 != null || node2 != null){
            if (node1 != null && (node2 == null || node1.data < node2.data)){

                if(node == null){
                    Node nodeTemp = new Node(node1.data);
                    node = nodeTemp;
                }else {
                    Node nodeTemp = new Node(node1.data);
                    nodeTemp.next=node;
                    node=nodeTemp;
                }
                node1 = node1.next;
            } else if( node2 !=null && (node1 == null || node1.data > node2.data)){

                if(node == null){
                    Node nodeTemp = new Node(node2.data);
                    node = nodeTemp;
                }else {
                    Node nodeTemp = new Node(node2.data);
                    nodeTemp.next=node;
                    node=nodeTemp;
                }
                node2 = node2.next;
            } else if (node1 != null && node2 != null && node1.data == node2.data) {
                Node nodeTemp = new Node(node2.data);
                nodeTemp.next=node;
                node=nodeTemp;
                node2 = node2.next;
            }
            //System.out.println(node);
        }
        return node;
    }
}
