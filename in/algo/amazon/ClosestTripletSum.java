package in.algo.amazon;


/*
*
* Given an array, arr of integers, and another number target,
* find three integers in the array such that their sum is closest to the target.
* Return the sum of the three integers.

Note: If there are multiple solutions, return the maximum one.

Examples :

Input: arr[] = [-7, 9, 8, 3, 1, 1], target = 2
Output: 2
Explanation: There is only one triplet present in the array where elements
* are -7,8,1 whose sum is 2.
*
Input: arr[] = [5, 2, 7, 5], target = 13
Output: 14
Explanation: There is one triplet with sum 12 and other with sum 14 in the array.
Triplet elements are 5, 2, 5 and 2, 7, 5 respectively.
Since abs(13-12) ==abs(13-14) maximum triplet sum will be preferred i.e 14.
*
* */
// 2,5,5,7


import java.util.Arrays;

public class ClosestTripletSum {

    public static void main(String[] args) {
        System.out.println(threeSumClosest2(new int[]{5, 2, 5, 7}, 13));
        System.out.println(threeSumClosest2(new int[]{-7, 9, 8, 3, 1, 1}, 2));
        System.out.println(threeSumClosest2(new int[]{3, 6, 8, 5, -9, -10, 0, -9, 10, -10}, 7));
        System.out.println(threeSumClosest2(new int[]{-9, 5, -7, 6 ,7 ,-10, 1 ,-10, 4 ,-8}, 10));
    }

    private static int threeSumClosest(int[] array, int target) {
        return (int) dfs(array, target, 0, 0, 0);
    }

    private static long dfs(int[] array, int target, long sum, int index, int count) {
        if (count == 3) return sum;
        if (index == array.length) return Integer.MAX_VALUE;
        long take = dfs(array, target, sum + array[index], index + 1, count + 1);
        long notTake = dfs(array, target, sum, index + 1, count);
        long taken = Math.abs(target - (take));
        long notTaken = Math.abs(target - (notTake));
        if (taken == notTaken) return Math.max(take, notTake);
        else if (taken < notTaken) return take;
        else return notTake;
    }

    //Faster two pointer technique
    private static int threeSumClosest2(int[] array, final int target) {
        int result = Integer.MIN_VALUE;
        Arrays.sort(array);
        //System.out.println(Arrays.toString(array));
        for (int a = 0; a < array.length; a++) {
            int X = target - array[a];
            int i=a+1;
            int j=array.length-1;
            while (i < j) {
                // If we find a pair
                int s = array[i] + array[j];
                if (s == X)
                    return target;

                    // If sum of elements at current
                    // pointers is less, we move towards
                    // higher values by doing i++
                else if (s < X) {
                    i++;
                }

                    // If sum of elements at current
                    // pointers is more, we move towards
                    // lower values by doing j--
                else {
                    j--;
                }
                if (Math.abs(X-s) < Math.abs(target - result))
                    result = s+array[a];
                else if (Math.abs(X-s) == Math.abs(target - result))
                    result = result > (s+array[a]) ? result : (s+array[a]);
            }

        }
        return result;
    }

}
