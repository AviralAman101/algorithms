package in.algo;

import java.util.Arrays;
import java.util.Comparator;

/*
*
* Given an array of strings arr[] of length n representing non-negative integers, arrange them in a manner, such that,
*  after concatanating them in order, it results in the largest possible number. Since the result may be very large,
* return it as a string.

Example 1:

Input:
n = 5
arr[] =  {"3", "30", "34", "5", "9"}
Output: "9534330"
Explanation:
Given numbers are  {"3", "30", "34", "5", "9"},
the arrangement "9534330" gives the largest value.
Example 2:

Input:
n = 4
arr[] =  {"54", "546", "548", "60"}
Output: "6054854654"
Explanation:
Given numbers are {"54", "546", "548", "60"}, the
arrangement "6054854654" gives the largest value.*/

public class LargestInteger {
    public static void main(String[] args) {
        System.out.println(printLargest(3 , new String[]{"3","9","90"}));
    }
    // Function to print the largest number
    static String printLargest(int n, String[] arr) {

        // Sorting the array in descending order based on customized comparison using Comparator interface
        Arrays.sort(arr,new Comparator<String>(){
            @Override
            public int compare(String x, String y){
                String xy = x+y;  // concatenating the current string with the next string
                String yx = y+x;  // concatenating the next string with the current string
                return yx.compareTo(xy);  // comparing the two concatenated strings in descending order
            }
        });

        String ans = "";
        for(int i=0; i<n; i++)
            ans += arr[i];  // concatenating all the strings in the sorted order

        return ans;  // returning the final result as a string
    }
}
