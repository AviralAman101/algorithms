package in.algo.random;


/*
Given a circular sheet of radius, r.
Find the total number of rectangles with integral length and width
that can be cut from the sheet that can fit on the circle, one at a time.

Examples :

Input: r=1
Output: 1
Explanation: Only 1 rectangle of dimensions 1x1.

Input: r=2
Output: 8
Explanation: The 8 possible rectangles are
(1x1)(1x2)(1x3)(2x1)(2x2)(2x3)(3x1)(3x2).

Expected Time Complexity: O(r2)
Expected Auxillary Space: O(1)
*/
public class NumberOfRectanglesInACircle {

    public static void main(String[] args) {
        System.out.println(rectanglesInCircle(1));
        System.out.println(rectanglesInCircle(2));
        System.out.println(rectanglesInCircle(74));
    }

    static int rectanglesInCircle(int r) {
        // code here
        int count = 0; // To store total unique values of i,j that satisfies the clauses
        int duplicate=0; // To calculate i, j values which are same
        for (int i = 1; i < 2*r; i++) {
            for (int j = 1; j <= i; j++) {

                if(Math.sqrt((Math.pow(i,2)+Math.pow(j,2)))<=2*r) {
                    if(i==j) duplicate++;
                    //System.out.println(i + ", "+j);
                    count++;
                }
            }
        }
        // count*2 : (1,2) and (2,1) are two different rectangles
        // duplicate : since (1,1) and (1,1) will be same i==j
        return count*2 - duplicate;
    }

}
