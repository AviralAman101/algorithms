package in.algo.dynamicProgramming;
/*
*
* Given an array of positive integers. Find the maximum length of Bitonic subsequence.
A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing. Return the maximum length of bitonic subsequence.

Note : A strictly increasing or a strictly decreasing sequence should not be considered as a bitonic sequence

Examples :

Input: n = 5, nums[] = [1, 2, 5, 3, 2]
Output: 5
Explanation: The sequence {1, 2, 5} is increasing and the sequence {3, 2} is decreasing so merging both we will get length 5.
Input: n = 8, nums[] = [1, 11, 2, 10, 4, 5, 2, 1]
Output: 6
Explanation: The bitonic sequence {1, 2, 10, 4, 2, 1} has length 6.
Input: n = 5, nums[] = [10, 20, 30]
Output: 0
Explanation: The decreasing or increasing part cannot be empty
Input: n = 3, nums[] = [10, 10, 10]
Output: 0
Explanation: The subsequences must be strictly increasing or decreasing
Constraints:
1 ≤ length of array ≤ 103
1 ≤ arr[i] ≤ 104
*
* */

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        System.out.println(LongestBitonicSequence(5, new int[]{1, 2, 5, 3, 2}));
        System.out.println(LongestBitonicSequence(3, new int[]{10, 10, 10}));
        System.out.println(LongestBitonicSequence(3, new int[]{5 ,7, 9}));
        System.out.println(LongestBitonicSequence(8, new int[]{1, 11, 2, 10, 4, 5, 2, 1}));
        System.out.println(LongestBitonicSequence(6, new int[]{1, 4, 2, 7, 9, 10}));
    }

    private static int LongestBitonicSequence(int n, int[] nums) {
        int[] increasing = new int[n];
        int[] decreasing = new int[n];
        increasing[0]=1;
        decreasing[n-1]=1;

        for (int i = 1; i < n; i++) {
            int value = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j])
                    value = Math.max(value, increasing[j]+1);
            }
            increasing[i] = value;
        }

        for (int i = n-2; i > 0; i--) {
            int value = 1;
            for (int j = i-1; j < n; j++) {
                if(nums[i]>nums[j])
                    value = Math.max(value, decreasing[j]+1);
            }
            decreasing[i] = value;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int value = increasing[i] + decreasing[i] - 1;
            if(value >max && (increasing[i]>1 && decreasing[i]>1)) max = value;
        }

        return max;
    }
}
