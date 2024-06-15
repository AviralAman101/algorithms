package in.algo.random;

import java.util.ArrayList;
import java.util.Arrays;

/*
* Given a number n, find out if n can be expressed as a+b,
* where both a and b are prime numbers. If such a pair exists,
* return the values of a and b, otherwise return [-1,-1] as an array of size 2.
Note: If [a, b] is one solution with a <= b, and [c, d] is
* another solution with c <= d, and a < c then  [a, b] is considered as our answer.

Examples

Input: n = 10
Output: 3 7
Explanation: There are two possiblities 3, 7 & 5, 5 are both prime
* & their sum is 10, but we'll pick 3, 7 as 3 < 5.
Input: n = 3
Output: -1 -1
Explanation: There are no solutions to the number 3.
Expected Time Complexity: O(n*loglog(n))
Expected Auxiliary Space: O(n)

Constraints:
2 <= n <= 106
*
* */
public class PrimePairWithTargetSum {
    public static void main(String[] args) {
        System.out.println(getPrimes(5));
    }

    private static void print(){
        for (int i = 0; i < 100; i++) {

        }
    }

    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public static ArrayList<Integer> getPrimes(int n) {

        ArrayList<Integer> result = new ArrayList<>(2);
        if(n%2 != 0){ // n is odd
            if(!isPrime(n-2)) {
                result.addAll(Arrays.asList(-1, -1));
            }else {
                result.addAll(Arrays.asList(2, n-2));
            }
            return result;
        }
        int min=n; // else if n is even
        for (int i = 2; i <=n/2 ; i++) {
            if(isPrime(i) && isPrime(n-i)){
                min=i;
                break;
            }
        }
        if(n==min) {
            result.addAll(Arrays.asList(-1,-1));
            return result;
        }
        result.add(min);
        result.add(n-min);
        return result;
    }
}
