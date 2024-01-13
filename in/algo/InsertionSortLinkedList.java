package in.algo;

import java.util.Objects;

public class InsertionSortLinkedList {

    /*
    * Given a singly linked list, sort the list (in ascending order) using insertion sort algorithm.

    Example 1:

    Input:
    N = 10
    Linked List = 30->23->28->30->11->14->
                  19->16->21->25
    Output :
    11 14 16 19 21 23 25 28 30 30
    Explanation :
    The resultant linked list is sorted.
    Example 2:

    Input :
    N = 7
    Linked List=19->20->16->24->12->29->30
    Output :
    12 16 19 20 24 29 30
    Explanation :
    The resultant linked list is sorted.
    * */

    private static class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    public static void main(String[] args) {
        //30 23 28 30 11 14 19 16 21 25
        Node n1 = new Node(11);
        Node n2 = new Node(23);
        Node n3 = new Node(28);
        Node n4 = new Node(30);
        Node n5 = new Node(11);
        n4.next=n5;
        n3.next=n4;
        n2.next=n3;
        n1.next=n2;
        Node node = insertionSort(n1);
        while (node != null){
            System.out.println(node.data);
            node=node.next;
        }
    }

    public static Node insertionSort(Node head_ref)
    {
        //code here
        Node sorted = null;
        Node head = head_ref;
        while (head != null){
            if(Objects.isNull(sorted)){
                sorted = new Node(head.data);
                head = head.next;
                continue;
            }else {
                if(sorted.data >= head.data){
                    Node node = new Node(head.data);
                    node.next=sorted;
                    sorted=node;
                    head=head.next;
                }else {
                    Node cursor = sorted;
                    while (Objects.nonNull(cursor)) {
                        if (cursor.data <= head.data && cursor.next != null && cursor.next.data <= head.data) {
                            cursor = cursor.next;
                        } else break;
                    }
                    Node temp = cursor != null ? cursor.next : null;
                    cursor.next = new Node(head.data);
                    cursor.next.next = temp;
                    head = head.next;
                }
            }
        }
        return sorted;
    }
}
