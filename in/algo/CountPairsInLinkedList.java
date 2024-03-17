package in.algo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
* Given two linked list head1 and head2 with distinct elements,
* determine the count of all distinct pairs from both lists whose sum is equal to the given value x.

Note: A valid pair would be in the form (x, y) where x is from first linked list and y is
* from second linked list.

Example 1:

Input:
head1 = 1->2->3->4->5->6
head2 = 11->12->13
x = 15
Output: 3
Explanation: There are total 3 pairs whose sum is 15 : (4,11) , (3,12) and (2,13)
Example 2:

Input:
head1 = 7->5->1->3
head2 = 3->5->2->8
x = 10
Output: 2
Explanation: There are total 2 pairs whose sum is 10 : (7,3) and (5,5)*/
public class CountPairsInLinkedList {
    public static void main(String[] args) {

    }

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                                 int x) {
        // add your code here
        Set<Integer> list1 = new HashSet<>();
        for (Integer i: head1){
            list1.add(i);
        }
        int count=0;
        for (Integer i: head2){
            if(list1.contains(x-i))
                count++;
        }
        return count;
    }
}
