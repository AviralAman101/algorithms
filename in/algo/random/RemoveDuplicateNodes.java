package in.algo.random;


/*
* Given a sorted linked list, delete all nodes that have duplicate
* numbers (all occurrences), leaving only numbers that appear once
* in the original list, and return the head of the modified linked list.

Examples:

Input: Linked List = 23->28->28->35->49->49->53->53
Output: 23 35
Explanation: The duplicate numbers are 28, 49 and 53 which are removed from the list.
Input: Linked List = 11->11->11->11->75->75
Output: Empty list
Explanation: All the nodes in the linked list have duplicates.
* Hence the resultant list would be empty.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ size(list) ≤ 105
*
* */

public class RemoveDuplicateNodes {
    public static void main(String[] args) {
        System.out.println(removeAllDuplicates(init()));
    }

    public static Node removeAllDuplicates(Node head) {
        Node curr = null;
        Node root = null;
        Node tempRepeated = null;
        while (head != null) {
            if (head.next != null && head.data == head.next.data) {
                head = getNextValueNode(head);
                continue;
            }
            if (root == null) {
                root = new Node(head.data);
                curr = root;
            } else {
                curr.next = new Node(head.data);
                curr = curr.next;
            }
            head = head.next;
        }
        return root;
    }

    private static Node getNextValueNode(Node head) {
        Node tempRepeated;
        tempRepeated = head;
        while (head.next != null && head.next.data == tempRepeated.data) {
            head = head.next;
        }
        if (head != null)
            head = head.next;
        return head;
    }

    private static Node init() { //Input: Linked List = 23->28->28->35->49->49->53->53

        Node n1 = new Node(23);
        Node n2 = new Node(28);
        Node n3 = new Node(28);
        Node n4 = new Node(35);
        Node n5 = new Node(49);
        Node n6 = new Node(49);
        Node n7 = new Node(53);
        Node n8 = new Node(53);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        return n1;

    }

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

        @Override
        public String toString() {
            return data + " -> " + next;
        }
    }
}
