package in.algo.amazon;

import java.util.HashSet;

/*Given two arrays of integers a[] and b[] of size n and m, the task is
 to check if a pair of values (one value from each array) exists such that
 swapping the elements of the pair will make the sum of two arrays equal.

Example 1:

Input: n = 6, m = 4, a[] = {4, 1, 2, 1, 1, 2}, b[] = (3, 6, 3, 3)
Output: 1
Explanation: Sum of elements in a[] = 11, Sum of elements in b[] = 15,
To get same sum from both arrays, we can swap following values: 1 from
a[] and 3 from b[]
Example 2:

Input: n = 4, m = 4, a[] = {5, 7, 4, 6}, b[] = {1, 2, 3, 8}
Output: 1
Explanation: We can swap 6 from array a[] and 2 from array b[]
Your Task
You don't need to read or print anything. You need to complete the function
findSwapValues() that takes array a, array b, integer n, and integer m as
parameters and returns 1 if there exists any such pair otherwise returns -1.

Expected Time Complexity: O(mlogm+nlogn).
Expected Auxiliary Space: O(1).
*/
public class FindSwapValues {


    private static long findSwapValues(long a[], int n, long b[], int m) {
        HashSet<Long> aSet = new HashSet<>();
        HashSet<Long> bSet = new HashSet<>();
        long sum=0;
        for (int i = 0; i < (n>m?n:m); i++) {
            long aI, bI ;
            if(i >= n) aI=0;
            else {
                aI = a[i];
                aSet.add(aI);
            }
            if(i >= m) bI=0;
            else {
                bI = b[i];
                bSet.add(bI);
            }
            sum += aI - bI;
        }
        if(sum==0) return 1;
        if(sum%2!=0) return -1;
        sum = sum/2;
        if (sum>0){
            //search aSet
            for (long i : bSet)
                if(aSet.contains(i+sum)) return 1;
        }else {
            //search bSet
            sum = Math.abs(sum);
            for (long i : aSet)
                if(bSet.contains(i+sum)) return 1;
        }
        //System.out.println("Difference : " + sum);
        return -1;
    }

    public static void main(String[] args) {
        long val = findSwapValues(new long[]{4, 1, 2, 1, 1, 2}, 6, new long[]{3, 6, 3, 3}, 4);
        System.out.println(val);
        System.out.println("------------1---------");
        long val3 = findSwapValues( new long[]{3, 6, 3, 3}, 4,new long[]{4, 1, 2, 1, 1, 2}, 6);
        System.out.println(val3);
        System.out.println("------------2---------");


        long val4 = findSwapValues( new long[]{5, 9, 16}, 3,new long[]{5, 8, 13}, 3);
        System.out.println(val4);
        System.out.println("Correct output : " +-1);
        System.out.println("------------3---------");


        long val5 = findSwapValues( new long[]{10 ,10 ,10 ,10}, 4,new long[]{5, 5, 5, 10}, 4);
        System.out.println(val5);
        System.out.println("Correct output : " +-1);
    }
}
