package in.algo.dynamicProgramming;


import java.util.Arrays;
import java.util.Comparator;

/*
* Given a ribbon of length `n` and a set of possible sizes,
* your task is to determine the maximum number of pieces that
* can be obtained by cutting the ribbon using any combination of the available sizes.



If it is not possible to make up the length `n` using the given sizes,
* return -1. If `n` is 0, return 0 since no cuts are required.



Example:

Let's say we have a ribbon of length 13 and the possible sizes are [3, 5, 8].

To achieve a length of 13, we can either cut the ribbon into one
* piece of length 5 and another piece of length 8 (as 5 + 8 = 13),
*  or we can cut it into one piece of length 3 and two pieces of
* length 5 (as 3 + 5 + 5 = 13). Since we want to maximize the
* number of pieces, we choose the second option and cut the
* ribbon into 3 pieces.



In summary, your goal is to find the maximum number of pieces that
* can be obtained by cutting the ribbon, using any combination of
* the available sizes, to achieve the desired length `n`.



Example 1: Input: n = 1, sizes = [5]

Output: 1

Explanation: In this case, the ribbon can be cut into one
* piece of length 1, resulting in a maximum of 1 piece.



Example 2: Input: n = 13, sizes = [3, 5, 8]

Output: 3

Explanation: With a ribbon length of 13, you can achieve the maximum
* number of pieces by cutting it into three pieces of lengths [3, 5, 5].



Example 3: Input: n = 3, sizes = [5]

Output: -1

Explanation: In this scenario, it is not possible to cut the
* ribbon of length 3 using the available size of 5, so the output is -1.
*
*
* */
public class MaximumPiecesOfRibbon {
    public static void main(String[] args) {
        System.out.println(cutRibbonPieces(13, new int[]{3, 5, 8}));
    }

    private static int maximumNoOfPieces(int n, int[] sizes) {
        int dp[][] = new int[sizes.length][n+1];
        Arrays.sort(sizes);
        for (int[] ar: dp) Arrays.fill(ar, -1);
        return maximumNoOfPiecesDfs(n,0, sizes, 0, dp);
    }


    // DFS with bottom up approach
    private static int maximumNoOfPiecesDfs(int lengthOfRibbon,int index,  int[] sizes, int count, int[][] dp){
        if(lengthOfRibbon == 0) return count;
        if(index >= sizes.length) return -1;
        if(dp[index][lengthOfRibbon] != -1) return dp[index][lengthOfRibbon];

        int take = 0;
        if(lengthOfRibbon - sizes[index] >= 0){
            take = maximumNoOfPiecesDfs(lengthOfRibbon-sizes[index], index, sizes, count+1, dp);
        }
        int notTake = maximumNoOfPiecesDfs(lengthOfRibbon, index+1, sizes, count, dp);

        int max = Math.max(take, notTake);
        dp[index][lengthOfRibbon] = max;

        return max;
    }

    //DP with 1D Tabulation approach
    private static int cutRibbonPieces(int n , int[] sizes){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < sizes.length; i++) {
            for (int j = 1; j <= n; j++) {
                int take = -1;
                if(j-sizes[i] >= 0 && dp[j-sizes[i]] != -1){
                    take = 1+ dp[j-sizes[i]];
                    dp[j] = Math.max(dp[j], take);
                }

            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
