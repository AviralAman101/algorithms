package in.algo;

import java.util.Arrays;

public class MaximumIndex {
    public static void main(String[] args) {
        System.out.println(maxIndexDiff(new int[]{1, 10}, 2));
        System.out.println(maxIndexDiff(new int[]{8, 9, 110, 1, 0, 80, 1, 1, 1}, 9));
    }

    private static int maxIndexDiff(int[] arr, int n) {
        if(n==1){
            return 0;
        }
        int RMax[] = new int[n];
        int LMin[] = new int[n];

        //Constructing LMin[] such that LMin[i] stores the minimum value
        //from (arr[0], arr[1], ... arr[i]).
        LMin[0] = arr[0];
        for (int i = 1; i < n; ++i)
            LMin[i] = Integer.min(arr[i], LMin[i - 1]);

        //Constructing RMax[] such that RMax[j] stores the maximum value
        //from (arr[j], arr[j+1], ..arr[n-1]).
        RMax[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; --j)
            RMax[j] = Integer.max(arr[j], RMax[j + 1]);

        int i = 0, j = 0, maxDiff = -1;
        //Traversing both arrays from left to right to find optimum j-i.
        //This process is similar to merge() of MergeSort.
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                //Updating the maximum difference.
                maxDiff = Integer.max(maxDiff, j - i);
                j++;
            } else
                i++;
        }
        //returning the maximum difference.
        return maxDiff;

    }

    private static int maxIndexDiffV2(int[] a, int n) {
        // Your code here
        int[] right = new int[n];
        int left[] = new int[n];
        Arrays.fill(right,-1);
        Arrays.fill(left,-1);
        int min=a[0];
        int pt=0;
        for (int i = 0; i < n; i++) {
            if(min>a[i]) {
                min=a[i];
                right[pt++] = i;
            }
        }
        min=a[n-1];
        pt=n-1;
        for (int i = n-1; i >=0; i--) {
            if(min<a[i]) {
                min=a[i];
                left[pt--] = i;
            }
        }
        int max=0;
        int i=0;
        int j=n-1;
        while (i!=-1){
            while (j!=-1){
                if(a[i]<=a[j] && max<j-i) {
                    max = j - i;
                    break;
                }else {
                    if(left[j] ==-1) break;
                    j=left[j];
                }
            }
            if(right[i]==-1) break;
            j=n-1;
            i=right[i];
        }
        return max;
    }

    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiffV1(int a[], int n) {
        int max=0;
        int min=a[0];
        int x;
        for (int i = 0; i < n; i++) {
            if(min < a[i]) continue;
            else min=a[i];
            if(n-i <= max) break;
            x=a[n-1];
            for (int j = n-1; j > i && j-i > max; j--) {
                if(x>a[j]) continue;
                x=a[j];
                if(a[i]<=x && max < j-i) {
                    max = j - i;
                    break;
                }
            }
        }
        return max;
    }
}
