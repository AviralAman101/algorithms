package in.algo;

import java.util.Arrays;
import java.util.Stack;

/*
* You are given an integer n, return the fibonacci series till the nth(0-based indexing) term.
* Since the terms can become very large return the terms modulo 109+7.

Example 1:

Input:
n = 5
Output:
0 1 1 2 3 5
Explanation:
0 1 1 2 3 5 is the Fibonacci series up to the 5th term.
Example 2:

Input:
n = 10
Output:
0 1 1 2 3 5 8 13 21 34 55
Explanation:
0 1 1 2 3 5 8 13 21 34 55 is the Fibonacci series up to the 10th term.*/
public class FibonnaciSeries {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Series(5)));
        System.out.println(Arrays.toString(Series(10)));
    }
    static int[] Series(int n) {
        // code here
        int l = 1000000007;
        n++;
        int[] ints = new int[n];
        ints[0]=0;
        if(n==1) return ints;
        ints[1]=1;
        if(n==2) return ints;
        for (int i = 2; i < n; i++) {
            ints[i]=(ints[i-1]+ints[i-2])%l;
        }
        return ints;
    }

}
