package in.algo.random;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* You are given a weighted undirected graph having n vertices numbered from 1 to n
* and m edges along with their weights. Find the shortest path between the vertex 1
* and the vertex n,  if there exists a path, and return a list of integers whose
* first element is the weight of the path, and the rest consist of the nodes on that path.
* If no path exists, then return a list containing a single element -1.

The input list of edges is as follows - {a, b, w}, denoting there is an edge
* between a and b, and w is the weight of that edge.

Note: The driver code here will first check if the weight of the path returned
* is equal to the sum of the weights along the nodes on that path,
* if equal it will output the weight of the path, else -2.
* In case the list contains only a single element (-1) it will simply output -1.

Examples :

Input: n = 5, m= 6, edges = [[1, 2, 2], [2, 5, 5], [2, 3, 4], [1, 4, 1], [4, 3, 3], [3, 5, 1]]
Output: 5
Explanation: Shortest path from 1 to n is by the path 1 4 3 5 whose weight is 5.
Input: n = 2, m= 1, edges = [[1, 2, 2]]
Output: 2
Explanation: Shortest path from 1 to 2 is by the path 1 2 whose weight is 2.
Input: n = 2, m= 0, edges = [ ]
Output: -1
Explanation: Since there are no edges, so no answer is possible.
Expected Time Complexity: O(m* log(n))
Expected Space Complexity: O(n+m)
*
* */
public class ShortestPathInWeightedGraph {
    public static void main(String[] args) {
        int[][] edges =new int[][]{{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        System.out.println(shortestPath(5, 6, edges));

        int[][] ints = {{
                1, 3, 3},
                {2, 3, 2},
                {1, 4, 2}};
        System.out.println(shortestPath(4,3,ints));

        int[][] ints2 = {{
                1, 2, 2},
                {2, 5, 5},
                {2, 3, 4},
                {1, 4, 1},
                {4, 3, 3},
                {3, 5, 1}};
        System.out.println(shortestPath(5,6, ints2));

        int[][] ints1 = {{
                2, 5, 1},
                {1, 2, 4},
                {2, 3, 5},
                {2, 5, 2},
                {1, 3, 5}};
        System.out.println(shortestPath(6, 5, ints1));
    }

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        long[][] dp = new long[2][n + 1];
        Arrays.fill(dp[0], 9999);
        dp[0][1]=0;
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < m; i++) {
                int st=edges[i][0];
                int end=edges[i][1];
                int weight=edges[i][2];
                if(dp[0][end]> weight+dp[0][st]) {
                    dp[0][end] = weight+dp[0][st];
                    if(st==1){
                        dp[1][end]=(st*10)+end;
                    }else {
                        dp[1][end] = (dp[1][st]*10)+end;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(dp[1]));
        return getResultList(dp, n);
    }

    private static List<Integer> getResultList(long[][] dp, int n) {
        ArrayList<Integer> sp = new ArrayList<>();
        if(dp[0][n] == 9999) sp.add(-1);
        else {
            long path = dp[1][n];
            int dist = (int)dp[0][n];
            sp.add(dist);
            while (path>0){
                sp.add(1, (int)path%10);
                path=path/10;
            }
        }
        return sp;
    }

}
