package in.algo.amazon;

/*
* Given an infinite number line. You start at 0 and can go either to the left or to the right.
* The condition is that in the ith move, you must take i steps. Given a destination d,
* find the minimum number of steps required to reach that destination.

Example 1:

Input: d = 2
Output: 3
Explaination: The steps taken are +1, -2 and +3.
Example 2:

Input: d = 10
Output: 4
Explaination: The steps taken are +1, +2, +3 and +4.
Your Task:
You do not need to read input or print anything. Your task is to complete the function
* minSteps() which takes the value d as input parameter and returns the minimum number
* of steps required to reach the destination d from 0.

Expected Time Complexity: O(sqrt(d))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ d ≤ 10000*/
public class MaxStepsToDestination {
    public static void main(String[] args) {
        System.out.println(minSteps(2));
        System.out.println(minSteps(10));
    }

    static int minSteps(int d) {
        int target = Math.abs(d);
        int sum = 0;
        int step = 0;

        // Execute the loop until the sum is less than the target or the difference
        // between the sum and target is not even
        while (sum < target || (sum - target) % 2 != 0) {
            // Increment the step count and add it to the sum
            step++;
            sum += step;
        }
        // Return the final step count
        return step;
    }
}
