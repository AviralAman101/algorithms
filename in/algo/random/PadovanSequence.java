package in.algo.random;


/*
* Given a number n, find the nth number in the Padovan Sequence.

A Padovan Sequence is a sequence which is represented by the following recurrence relation
P(n) = P(n-2) + P(n-3)
P(0) = P(1) = P(2) = 1

Note: Since the output may be too large, compute the answer modulo 10^9+7.

Examples :

Input: n = 3
Output: 2
Explanation: We already know, P1 + P0 = P3 and P1 = 1 and P0 = 1
Input: n = 4
Output: 2
Explanation: We already know, P4  = P2 + P1 and P2 = 1 and P1 = 1
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
*
* */
public class PadovanSequence {
    public static void main(String[] args) {
        System.out.println(padovanSequence(7));
    }
    public static int padovanSequence(int n){

        int pand_n_3 = 1;  // n-3 Padovan No.
        int pand_n_2 = 1;  // n-2 Padovan No.
        int pand_n_1 = 1;  // n-1 Padovan No.
        int res = 0;
        int mod = (int)Math.pow(10,9)+7;

        for (int i = 3; i <= n; i++) {
            res = (pand_n_3 + pand_n_2)%mod;
            pand_n_3 = pand_n_2%mod;
            pand_n_2 = pand_n_1%mod;
            pand_n_1 = res;
        }

        return res;
    }
}
