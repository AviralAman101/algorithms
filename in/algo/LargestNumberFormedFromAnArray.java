package in.algo;

import java.util.Arrays;
import java.util.Comparator;

/*
*
* Given an array of strings arr[] of length n representing non-negative integers, arrange them in a manner, such that, after concatanating them in order, it results in the largest possible number. Since the result may be very large, return it as a string.

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
arrangement "6054854654" gives the largest value.
* */
public class LargestNumberFormedFromAnArray {
    public static void main(String[] args) {
        System.out.println(printLargest(5, new String[]{"3", "30", "34", "5", "9"}));
    }


    static String printLargest(int n, String[] arr) {
        // code here
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String x = o1+o2;
                String y = o2+o1;
                return y.compareTo(x);
            }

        });
        String res="";
        for (int i = 0; i < n; i++) {
            res +=arr[i];
        }
        return res;
    }
}
