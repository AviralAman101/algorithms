package in.algo.amazon;


/*
* In a restaurant, two waiters, A and B, receive n orders per day,
* earning tips as per arrays arr[i] and brr[i] respectively. If A takes the ith order,
* the tip is arr[i] rupees; if B takes it, the tip is brr[i] rupees.

To maximize total tips, they must distribute the orders such that:

A can handle at most x orders
B can handle at most y orders
Given that x + y ≥ n, all orders can be managed by either A or B.
* Return the maximum possible total tip after processing all the orders.

Examples

Input: n = 5, x = 3, y = 3, arr = {1, 2, 3, 4, 5}, brr = {5, 4, 3, 2, 1}
Output: 21
Explanation: Person A will serve the 3rd, 4th and 5th order while person B
* will serve the rest so the total tip from A = 3+4+5 & B = 5 + 4 i.e. 21.


Input: n = 8, x = 4, y = 4, arr = {1, 4, 3, 2, 7, 5, 9, 6}, brr = {1, 2, 3, 6, 5, 4, 9, 8}
Output: 43
Explanation: Person A will serve 1st, 2nd, 5th and 6th order while Person B
* will serve the rest & the total tip will be 43.


Input: n = 7, x = 3, y = 4, arr[] = {8, 7, 15, 19, 16, 16, 18}, brr[] = {1, 7, 15, 11, 12, 31, 9}
Output: 110
Explanation: Person A will serve orders 8,19,18 while person B will serve 7,15, 12 & 31.
* */


import java.util.Arrays;

public class MaximumTipCalculator {
    public static void main(String[] args) {
        //n = 5, x = 3, y = 3, arr = {1, 2, 3, 4, 5}, brr = {5, 4, 3, 2, 1}
        System.out.println(maxTip(5, 3, 3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}));
        //Ans- 21
        //Test 2
        // 9
        //4
        //7
        //4 7 10 8 7 3 2 8 7
        //3 9 5 5 5 6 8 6 7
        System.out.println(maxTip(9, 4, 7, new int[]{4, 7, 10, 8, 7, 3, 2, 8, 7},
                new int[]{3, 9, 5, 5, 5, 6, 8, 6, 7}));
    }
    
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        long sum = 0;
        int[][] diffArray = new int[3][n]; // Array to store and sort the Tips
        for (int i = 0; i < n; i++) {
            diffArray[0][i] = Math.abs(arr[i] - brr[i]); // difference of A and B Tips
            diffArray[1][i] = arr[i]; // Waiter A Tip
            diffArray[2][i] = brr[i]; //  Waiter B Tip
        }
        quickSort(diffArray, 0, n - 1);
        Arrays.stream(diffArray).forEach(a -> System.out.println(Arrays.toString(a)));
        for (int i = 0; i < n; i++) {
            if (diffArray[1][i] > diffArray[2][i] && x > 0) {
                x--;
                sum += diffArray[1][i];
            } else if (diffArray[1][i] > diffArray[2][i] && x <= 0) {
                y--;
                sum += diffArray[2][i];
            } else if (diffArray[1][i] < diffArray[2][i] && y > 0) {
                y--;
                sum += diffArray[2][i];
            } else if (diffArray[1][i] < diffArray[2][i] && y <= 0) {
                x--;
                sum += diffArray[1][i];
            } else sum += diffArray[1][i];
        }
        return sum;
    }

    static void swap(int[][] arr, int i, int j) {
        int temp = arr[0][i];
        arr[0][i] = arr[0][j];
        arr[0][j] = temp;

        //swap Waiter A Tip
        temp = arr[1][i];
        arr[1][i] = arr[1][j];
        arr[1][j] = temp;

        //swap Waiter B Tip
        temp = arr[2][i];
        arr[2][i] = arr[2][j];
        arr[2][j] = temp;
    }

    static int partition(int[][] arr, int low, int high) {
        // Choosing the pivot
        int pivot = arr[0][high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[0][j] > pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[][] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
