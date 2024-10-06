package in.algo.dynamicProgramming;

/*Catalan numbers are defined as a mathematical sequence that consists of positive integers,
which can be used to find the number of possibilities of various combinations.

The nth term in the sequence denoted Cn, is found in the following formula: \frac={(2n)!}/{((n + 1)! n!)}

The first few Catalan numbers for n = 0, 1, 2, 3, … are : 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …  */
public class CatalanNumberUsingDP {
    static int catalanDPBottomUp(int n)
    {
        // Table to store results of subproblems
        long catalan[] = new long[n + 2];

        // Initialize first two values in table
        catalan[0] = 1;
        catalan[1] = 1;

        // Fill entries in catalan[]
        // using recursive formula
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i]
                        += ((catalan[j]%1000000007) * (catalan[i - j - 1]%1000000007))%1000000007;
            }
        }

        // Return last entry
        return (int)(catalan[n] % 1000000007);
    }

    // Driver code
    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++) {
            System.out.print(catalanDPBottomUp(i) + " ");
        }
    }
}
