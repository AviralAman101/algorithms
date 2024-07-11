package in.algo.amazon;


/*
* Search in Rotated Sorted Array

Given a sorted (in ascending order) and rotated array arr of distinct elements which may be rotated at some point and given an element key, the task is to find the index of the given element key in the array arr. The whole array arr is given as the range to search.

Rotation shifts elements of the array by a certain number of positions, with elements that fall off one end reappearing at the other end.

Note:- 0-based indexing is followed & returns -1 if the key is not present.

Examples :

Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 10
Output: 5
Explanation: 10 is found at index 5.
Input: arr[] = [3, 5, 1, 2], key = 6
Output: -1
Explanation: There is no element that has value 6.
Expected Time Complexity: O(log n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106
1 ≤ key ≤ 105*/
public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 5, 1, 6}, 6));
    }

    private static int search(int[] arr, int key) {
        // Complete this function
        int i=1;
        for (; i < arr.length; i++) {
            int i1 = arr[i];
            if(i1==key) return i;
            if(i1 < arr[i-1]){
                break;
            }
        }
        //System.out.println(Arrays.binarySearch(arr, i, arr.length, key));
        return binSearch(arr, i , arr.length, key);
    }

    private static int binSearch(int[] arr, int start, int end, int target){
        if(start>=arr.length) return -1;
        int mid = (start + end)/2;
        if(arr[mid] == target) return mid;
        if(start == mid) return -1;
        if(arr[mid] > target)
            return binSearch(arr, start, mid, target);
        if(arr[mid] < target)
            return binSearch(arr, mid+1, end, target);
        return -1;
    }
}
