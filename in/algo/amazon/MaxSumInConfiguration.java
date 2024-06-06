package in.algo.amazon;

import java.math.BigInteger;


/*
*
* Given an integer array(0-based indexing) a of size n. Your task is to return
* the maximum value of the sum of i*a[i] for all 0<= i <=n-1, where a[i]
* is the element at index i in the array. The only operation allowed is to
* rotate(clockwise or counterclockwise) the array any number of times.

Example 1:

Input: n = 4, a[] = {8, 3, 1, 2}
Output: 29
Explanation: All the configurations possible by rotating the elements are:
3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11, so the maximum sum will be 29.
Example 2:

Input: n = 3, a[] = {1, 2, 3}
Output: 8
Explanation: All the configurations possible by rotating the elements are:
1 2 3 here sum is 1*0+2*1+3*2 = 8
3 1 2 here sum is 3*0+1*1+2*2 = 5
2 3 1 here sum is 2*0+3*1+1*2 = 5, so the maximum sum will be 8.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).
* */
public class MaxSumInConfiguration {
    public static void main(String[] args) {
        System.out.println(max_sum(new int[]{8, 3, 1, 2}, 4));
        System.out.println(max_sum(new int[]{1, 2, 3}, 3));
    }
    static long max_sum(int a[], int n) {
        BigInteger sumConstant= BigInteger.valueOf(0);
        BigInteger[] vals = new BigInteger[n];
        BigInteger currVal= BigInteger.valueOf(0);
        for (int i = n-1; i >= 0; i--) {
            vals[i] = BigInteger.valueOf(a[i]);
            sumConstant = sumConstant.add(vals[i]);
            currVal = currVal.add(BigInteger.valueOf(i).multiply(vals[i]));
        }
        BigInteger max = currVal;
        BigInteger n1 = BigInteger.valueOf(n);
        for (int i = 0; i < n-1; i++) {
            currVal = currVal.add(n1.multiply(vals[i]).subtract(sumConstant));
            if(currVal.compareTo(max) >0) max = currVal;
        }
        return max.longValue();
    }

    static long max_sumWithoutBigInt(int a[], int n) {
        long sumConstant=0;
        long currVal=0;
        for (int i = n-1; i >= 0; i--) {
            sumConstant+=a[i];
            currVal += (long)(i)*(long)a[i];
        }

        long max = currVal;
        for (int i = 0; i < n-1; i++) {
            currVal = currVal + (long)n*(long)a[i] - sumConstant;
            if(currVal>max) max = currVal;
        }

        return max;
    }

//    public static void main(String args[]) throws FileNotFoundException {
//        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\avira\\Downloads\\testx1.txt"));
//            int n = sc.nextInt();
//            int arr[] = new int[n];
//            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
//            System.out.println(max_sum(arr, n));
//    }
}
