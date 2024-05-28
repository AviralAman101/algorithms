package in.algo.random;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*

* Given an array cost[] of positive integers of size n and an integer w,
* where cost[i] represents the cost of an i kg packet of oranges, the
* task is to find the minimum cost to buy exactly w kg of oranges.
* The cost array has a 1-based indexing. If buying exactly w kg of
* oranges is impossible, then return -1.
Note:
*
1. cost[i] = -1 means that i kg packet of orange is unavailable.
2. It may be assumed that there is an infinite supply of all available packet types.

Example 1:

Input:
n = 5
cost[] = {20, 10, 4, 50, 100}
w = 5
Output:
14
Explanation:
Purchase the 2kg packet for 10 coins and the 3kg packet for 4 coins to buy 5kg of oranges for 14 coins.
Example 2:

Input:
n = 5
cost[] = {-1, -1, 4, 3, -1}
w = 5
Output:
-1
Explanation:
It is not possible to buy 5 kgs of oranges.
Your Task:
You don't need to read input or print anything. Complete the function
* minimumCost() which takes integers n and w, and integer array cost[]
* as input parameters and returns the minimum cost to buy exactly w kg of oranges,
* If buying exactly w kg of oranges is impossible, then return -1.
*
* */
public class MinCostToFillBag {
    public static void main(String[] args) {

        System.out.println(minimumCostGFG(4,9,new int[]{5, 3, 7 ,10}));
    }

    private static boolean minimumCost(int n, int weight, int[] ints) {
        int[][] dp = new int[n + 1][weight + 1];
        for (int i = 0; i <= weight ; i++) {
            dp[0][i] = 999999;
        }

        for (int i = 1; i <= n; i++) {
            if(ints[i-1] == -1) ints[i-1] = 999999;
            dp[n][0]=0;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=weight ; j++) {
                System.out.println("i:"+i+", j:"+j);
                if(j >= i) {
                    if(j%i==0)
                        dp[i][j] =Math.min(dp[i][j-i] + ints[i-1], Math.min((j/i) * ints[i - 1], dp[i-1][j]));
                    else {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-i] + ints[i-1]);
                    }
                }else dp[i][j] = dp[i-1][j];
            }
           // System.out.println(Arrays.toString(dp[i]));
        }
        //Arrays.stream(dp).forEach(a -> System.out.println(Arrays.toString(a)));

        return dp[n][weight] < 999999 ? true : false ;
    }

        public static int minimumCostGFG(int n, int w, int[] cost) {
            int INF = 999999999;

            // Lists to store the values and weights of available packets
            List<Integer> val = new ArrayList<>();
            List<Integer> wt = new ArrayList<>();

            // Traverse the original cost[] array and skip unavailable packets
            // and make val[] and wt[] arrays
            for (int i = 0; i < n; i++) {
                if (cost[i] != -1) {
                    val.add(cost[i]);
                    wt.add(i + 1);
                }
            }

            // The new size of available packets
            n = val.size();
            int[][] min_cost = new int[n + 1][w + 1];

            // Fill the 0th row with infinity
            for (int i = 0; i <= w; i++) {
                min_cost[0][i] = INF;
            }

            // Fill the 0th column with 0
            for (int i = 1; i <= n; i++) {
                min_cost[i][0] = 0;
            }

            // Fill the matrix according to the condition
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= w; j++) {
                    if (wt.get(i - 1) > j) {
                        min_cost[i][j] = min_cost[i - 1][j];
                    } else {
                        min_cost[i][j] =
                                Math.min(min_cost[i - 1][j],
                                        min_cost[i][j - wt.get(i - 1)] + val.get(i - 1));
                    }
                }
            }
//            System.out.println(wt);
//            System.out.println(val);
//            Arrays.stream(min_cost).forEach(a -> System.out.println(Arrays.toString(a)));
            // Exactly weight w cannot be made by given weights
            return (min_cost[n][w] == INF) ? -1 : min_cost[n][w];
        }


}
