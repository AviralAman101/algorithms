package in.algo;


import java.util.Arrays;

/*
* Given n integer ranges, the task is to return the maximum occurring integer in the given ranges. If more than one such integer exists, return the smallest one.
The ranges are in two arrays l[] and r[].  l[i] consists of the starting point of the range and r[i] consists of the corresponding endpoint of the range & a maxx which is the maximum value of r[].

For example, consider the following ranges.
l[] = {2, 1, 3}, r[] = {5, 3, 9)
Ranges represented by the above arrays are.
[2, 5] = {2, 3, 4, 5}
[1, 3] = {1, 2, 3}
[3, 9] = {3, 4, 5, 6, 7, 8, 9}
The maximum occurred integer in these ranges is 3.

Examples :

Input: n = 4, l[] = {1,4,3,1}, r[] = {15,8,5,4}, maxx = 15
Output: 4
Explanation: The given ranges are [1,15] [4, 8] [3, 5] [1, 4]. The smallest
*  number that is most common or appears most times in the ranges is 4.
Input: n = 5, l[] = {1,5,9,13,21}, r[] = {15,8,12,20,30}, maxx = 30
Output: 5
Explanation: The given ranges are [1, 15] [5, 8] [9, 12] [13, 20] [21, 30].
* The smallest number that is most common or appears most times in the ranges is 5.
Expected Time Complexity: O(n+maxx).
Expected Auxiliary Space: O(maxx), maxx is maximum element in r[]
*
* */
public class MaximumOccurredInteger {
    public static void main(String[] args) {
//        System.out.println(maxOccured(4, new int[]{1,4,3,1}, new int[]{15,8,5,4}, 15));
//        System.out.println(maxOccured(5, new int[]{1,5,9,13,21}, new int[]{15,8,12,20,30}, 30));
        System.out.println(maxOccured(10, new int[]{2 ,8 ,5 ,1 ,10 ,5 ,9 ,9 ,3 ,5},
                new int[]{10 ,10, 6, 8 ,10, 10 ,10, 9 ,6 ,5},10));

    }
    public static int maxOccured(int n, int l[], int r[], int maxx) {
//        int[] prefixSumArray = new int[(int) Math.pow(10, 6)];
        int[] prefixSumArray = new int[maxx+2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            prefixSumArray[l[i]]++;
            prefixSumArray[r[i]+1]--;
        }
        int index=-1;
        int total = 0;
        for (int i = 0; i < prefixSumArray.length; i++) {
            total = total+prefixSumArray[i];
            if(total > max){
                max = total;
                index = i;
            }

        }
        //System.out.println(Arrays.toString(prefixSumArray));
        return index;
    }

}
