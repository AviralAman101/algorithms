package in.algo.amazon;

/*
* You have given two sorted arrays arr1[] & arr2[] of distinct elements. The
* first array has one element extra added in between. Return the index of the extra element.

Note: 0-based indexing is followed.

Examples

Input: n = 7, arr1[] = {2,4,6,8,9,10,12}, arr2[] = {2,4,6,8,10,12}
Output: 4
Explanation: In the first array, 9 is extra added and it's index is 4.
Input: n = 6, arr1[] = {3,5,7,8,11,13}, arr2[] = {3,5,7,11,13}
Output: 3
Explanation: In the first array, 8 is extra having index 3.
*
*
* */


public class FindExtraElement {
    public static void main(String[] args) {
       System.out.println(findExtra(7, new int[]{2,4,6,8,9,10,12}, new int[]{2,4,6,8,10,12}));
        System.out.println(findExtra(7, new int[]{4, 10, 14 ,17 ,18 ,25 ,27}, new int[]{4 ,14 ,17 ,18 ,25 ,27}));
        System.out.println(findExtra(6, new int[]{3,5,7,8,11,13}, new int[]{3,5,7,11,13}));
        System.out.println(findExtra(2, new int[]{11 ,22}, new int[]{11}));
    }

    public static int findExtra(int n, int arr1[], int arr2[]) {
        return binarySearch(arr1,0, n-1, arr2);
    }

    static int binarySearch(int arr[], int l, int r,  int[] arr2)
    {
        if(l==r) return r;
        int mid = (l+r)/2;
        if(arr[mid] != arr2[mid]){
            if(mid-1 != -1 && arr[mid] == arr2[mid-1]){
                //search left
                return binarySearch(arr, l, mid, arr2);
            }else if(mid != arr2.length-1 && arr[mid] == arr2[mid+1]){
                //search right
                return binarySearch(arr, mid+1, r, arr2);
            } else return mid;
        }else {
            return binarySearch(arr, mid+1, r, arr2);
            //search right
        }
    }
}
