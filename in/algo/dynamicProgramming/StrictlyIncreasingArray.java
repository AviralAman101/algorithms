package in.algo.dynamicProgramming;

import java.util.Arrays;

/*
* Given an array nums of n positive integers. Find the minimum number of operations required to modify the array such
* that array elements are in strictly increasing order (nums[i] < nums[i+1]).
Changing a number to greater or lesser than original number is counted as one operation.

Note: Array elements can become negative after applying operation.

Example 1:

Input:
n = 6
nums = [1, 2, 3, 6, 5, 4]
Output:
2
Explanation:
By decreasing 6 by 2 and increasing 4 by 2, nums will be like [1, 2, 3, 4, 5, 6] which is stricly increasing.
Example 2:

Input:
n = 4
nums = [1, 1, 1, 1]
Output:
3
Explanation:
One such array after operation can be [-2, -1, 0, 1]. We require atleast 3 operations for this example.
* */
public class StrictlyIncreasingArray {
    public static void main(String[] args) {
        int ar[] = new int[]{1, 2, 3, 6, 5, 4};
        int ar1[] = new int[]{1, 1, 1, 1};
        int ar2[] = new int[]{1 ,6 ,4 ,6 ,4};
        int ar3[] = new int[]{10 ,5 ,5 ,2 ,4 ,10 ,3 ,2 ,7 ,9};
        int ar4[] = new int[]{4, 5 ,1 ,6 ,3 ,2, 8, 3
        };
        int i = min_operations1(ar2);
        System.out.println(i);
    }

    public static int min_operations(int []nums)
    {
        int st=0, lt=0;
        int li=0, lj=0;
        // Code here
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] >= nums[i+1])  {
                if(lj-li <= i-st){
                    if(lj-li == i-st && ((i)==nums.length-1))
                        continue;
                    lj=i;
                    li=st;
                }
                    st=i+1;

            }
        }
        System.out.println(li);
        System.out.println(lj);
        int ct=0;
        for (int i = li; i > 0 ; i-=2) {
            if(i==1 ) {
                if(nums[i] <= nums[i-1])
                    ct++;
                continue;
            }else {
                if(nums[i] > nums[i-2] && Math.abs(Math.abs(nums[i-2])-Math.abs(nums[i])) >1 )
                    ct++;
                else ct+=2;
                nums[i-2] = nums[i-2] > nums[i]-2 ? nums[i] -2 : nums[i-2];
            }
        }
//        System.out.println("Ct "+ct);
        for (int i = lj; i < nums.length-1; i+=2) {
            if(i== nums.length-2){
                if(nums[i] >= nums[i+1])
                    ct++;
            }else {
                if(nums[i] < nums[i+2] && (Math.abs(nums[i+2])-Math.abs(nums[i])) >1)
                    ct++;
                else ct+=2;
                nums[i+2] = nums[i+2] < nums[i]+2 ? nums[i] +2 : nums[i+2];
            }
        }
//        System.out.println("Count : " + ct);
        return ct;
    }

    public static int min_operations1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                // If nums[i] is greater than nums[j], then it can be added to the set of LIS
                if (nums[i] > nums[j] && nums[i] - nums[j] > i - j - 1) {
                    temp = Math.max(temp, dp[j]);
                }
            }
            // Length of maximum increasing subsequence whose last element is nums[i]
            dp[i] = Math.max(dp[i], 1 + temp);
        }
        System.out.println(Arrays.toString(dp));
        // Total operations needed to apply
        return n - Arrays.stream(dp).max().getAsInt();
    }
}
