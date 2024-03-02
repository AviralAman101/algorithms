package in.algo;

/*
*
* Given an 0-indexed array of integers arr[] of size n, find its peak element. An element is considered to be peak if
* it's value is greater than or equal to the values of its adjacent elements (if they exist).

Note: The output will be 1 if the index returned by your function is correct; otherwise, it will be 0.

Example 1:

Input:
n = 3
arr[] = {1, 2, 3}
Peak element's index: 2
Output:
1
Explanation:
If the index returned is 2, then the output printed will be 1. Since arr[2] = 3 is greater than its adjacent elements,
* and there is no element after it, we can consider it as a peak element. No other index satisfies the same property.
Example 2:

Input:
n = 7
arr[] = {1, 1, 1, 2, 1, 1, 1}
Output:
1
Explanation:
In this case there are 5 peak elements with indices as {0,1,3,5,6}. Returning any of them will give you correct answer.
Your Task:
You don't have to read input or print anything. Complete the function peakElement() which takes the array arr[] and
* its size n as input parameters and return the index of the peak element.
*
* */
public class PeakElement {
    public static void main(String[] args) {
        System.out.println(peakElement(new int[]{1, 1, 1, 2, 1, 1, 1}, 7));
    }
    // Function to find the peak element
    // arr[]: input array
    // n: size of array a[]
    public static int peakElement(int[] arr,int n)
    {
        int prev =0, next=0;
        for (int i = 0; i < n; i++) {
            prev = i-1>0?i-1 : i;
            next = i+1 < n ? i+1 : i;
            if(arr[i]>=arr[prev] && arr[i] >=arr[next])
                return i;
        }
        return -1;
    }
}
