package in.algo;


/*
*
* You are given a Linked list of size n. The list is in alternating ascending and descending orders.
* Sort the given linked list in non-decreasing order.

Example 1:

Input:
n = 6
LinkedList = 1->9->2->8->3->7
Output: 1 2 3 7 8 9
Explanation:
After sorting the given list will be 1->2->3->7->8->9.
Example 2:

Input:
n = 5
LinkedList = 13->99->21->80->50
Output: 13 21 50 80 99
Explanation:
After sorting the given list will be 13->21->50->80->99.*/

public class SortLinkedList {
    public static void main(String[] args) {
        SortLinkedList main = new SortLinkedList();
        Node t1 = main.prepareTestData1();
        //System.out.println();
        Node sorted = main.sort(t1);
        System.out.println(sorted);

    }

    public Node prepareTestData1(){
        Node root = new Node(1);
        Node nine = new Node(9);
        Node two = new Node(2);
        Node eight = new Node(8);
        Node three = new Node(3);
        Node seven = new Node(7);
        three.next=seven;
        eight.next=three;
        two.next=eight;
        nine.next=two;
        root.next=nine;
        return root;
    }

    class Node {
        int data;
        Node next;

        public Node (int data){
            //System.out.print(data);
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "" +data +
                    ", ->" + next ;
        }
    }
    public Node sort(Node head){
        //your code here, return the head of the sorted list
        int i=0;
        Node a = null;
        Node b= null;
        Node temp =null;
        Node last=null;
        while (head != null){
            if(i%2==0){
                if(a==null){
                    a=new Node(head.data);
                    last=a;
                }else {
                    if (a.next==null){
                        temp=new Node(head.data);
                        a.next=temp;
                        last=temp;
                    }else {
                        Node newNode = new Node(head.data);
                        temp.next = newNode;
                        temp = newNode;
                        last=newNode;
                    }
                }
            }else {
                if(b==null){
                    b=new Node(head.data);
                }else {
                    Node nn = new Node(head.data);
                    nn.next=b;
                    b=nn;
                }            }
            i++;
            head=head.next;
        }
        last.next=b;
        //System.out.println(prev);
        return a;
    }


}
