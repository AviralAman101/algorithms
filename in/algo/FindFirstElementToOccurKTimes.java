package in.algo;


/*
*
* Given an array of n integers. Find the first element that occurs atleast k number of times.
* If no such element exists in the array, then expect the answer to be -1.

Example 1:

Input :
n = 7, k = 2
a[] = {1, 7, 4, 3, 4, 8, 7}
Output :
4
Explanation :
Both 7 and 4 occur 2 times. But 4 is first that occurs twice.
As at index = 4, 4 has occurred twice whereas 7 appeared twice
at index 6.
Example 2:

Input :
n = 10, k = 3
a[] = {3, 1, 3, 4, 5, 1, 3, 3, 5, 4}
Output :
3
Explanation :
Here, 3 is the only number that appeared atleast 3 times in the array.
* */

import java.util.Arrays;
import java.util.HashMap;

public class FindFirstElementToOccurKTimes {

    public static void main(String[] args) {
        System.out.println(firstElementKTime(7, 2, new int[]{1, 7, 4, 3, 4, 8, 7}));
    }

    public static int firstElementKTime(int n, int k, int[] a) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = a[i];
            if(count.containsKey(key)){
                Integer integer = count.get(key);
                if(++integer == k)
                    return key;
                else count.put(key, integer);
            }else count.put(key, 1);
        }
        return -1;
    }
}
