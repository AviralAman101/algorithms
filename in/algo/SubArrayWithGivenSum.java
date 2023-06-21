package in.algo;

import java.util.ArrayList;

//Given an unsorted array A of size N
// that contains only positive integers, find a continuous
// sub-array that adds to a given number S and return the
// left and right index(1-based indexing) of that subarray.
//In case of multiple subarrays, return the subarray indexes
// which come first on moving from left to right.
//Note:- You have to return an ArrayList consisting of two elements left and right.
// In case no such subarray exists return an array consisting of element -1.
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3,7,5},5,12));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s){
        int start=0;
        int sum=0;
        ArrayList<Integer> al = new ArrayList<>();
        if(s!=0) {

            for (int i = 0; i < n; i++) {
                sum += arr[i];
                while (sum > s) {
                    sum -= arr[start++];
                }
                if (sum == s) {
                    al.add(start + 1);
                    al.add(i + 1);
                    return al;
                }
            }
        }
        al.add(-1);
        return al;
    }


    static ArrayList<Integer> subarraySum_LessEfiicient(int[] arr, int n, int s){
        // Your code here
        int sum=0;
        int start = 0;
        int l = arr.length;
        ArrayList<Integer> al = new ArrayList<>(2);
        for(int i=start; i<l;){
            if((sum+=arr[i++]) == s){
                al.add(start+1);
                al.add(i);
                return al;
            }
            if(sum>s && (i=++start)<l){
                sum=0;
            }
        }
        al.add(-1);
        return al;
    }
}
