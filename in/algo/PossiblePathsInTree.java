package in.algo;

import java.util.*;

/*
* Given a weighted tree with n nodes and (n-1) edges. You are given q queries.
* Each query contains a number x. For each query, find the number of paths in
* which the maximum edge weight is less than or equal to x.

Note: Path from A to B and B to A are considered to be the same.

Example 1:

Input:
n = 3
edges {start, end, weight} = {{1, 2, 1}, {2, 3, 4}}
q = 1
queries[] = {3}
Output:
1
Explanation:
Query 1: Path from 1 to 2
Example 2:

Input:
n = 7
edges {start, end, weight} = {{1, 2, 3}, {2, 3, 1}, {2, 4, 9}, {3, 6, 7}, {3, 5, 8}, {5, 7, 4}}
q = 3
queries[] = {1, 3, 5}
Output:
1 3 4
Explanation:
Query 1: Path from 2 to 3
Query 2: Path from 1 to 2, 1 to 3, and 2 to 3
Query 3: Path from 1 to 2, 1 to 3, 2 to 3, and 5 to 7
* */

public class PossiblePathsInTree {
    public static void main(String[] args) {
        int[] queries = new int[]{1, 3, 5};
        int[] queries2 = new int[]{3 ,3 ,2 ,0 ,2 ,0 ,3 ,0 ,3};
        int[][] edges = new int[][]{{1, 2, 3}, {2, 3, 1}, {2, 4, 9}, {3, 6, 7}, {3, 5, 8}, {5, 7, 4}};
        int[][] edges1 = new int[][]{{3 ,1 ,3}, {4, 2, 2}, {3,4,1}};
        int n =7;
        int q=3;
        System.out.println(maximumWeight0(4,edges1,9,queries2));

        //printAll(edges[0], edges, 7,0);
    }
    static ArrayList<Integer> maximumWeight0(int n, int[][] edges, int q, int[] queries){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            //System.out.println("XXX");
            Integer integer = map.get(edges[i][2]);
            if(integer==null)
                map.put(edges[i][2], 1);
            else map.put(edges[i][2], integer+1);
            printAll(n, edges, q, queries, edges[i],0, i, edges[i][2], map);
        }

        //System.out.println(map);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int c=0;
            int k = queries[i];
            while (k>=0){
                Integer c1 = map.get(k);
                c+= c1==null? 0: c1;
                k--;
            }
            res.add(c);
        }
        //System.out.println(res);
        return res;
    }
    static void printAll(int n, int edges[][], int q, int queries[], int[] curr, int startIndex, int f, int max
                                        , Map<Integer, Integer> map) {
        for (int i = 0; i < n-1; i++) {
            if(i==f){
                continue;
            }
            if(edges[i][0]==curr[1]){
                //curr=;

                if(max<edges[i][2])max=edges[i][2];
                Integer integer = map.get(max);
                if(integer==null)
                    map.put(max, 1);
                else map.put(max, integer+1);
                //System.out.println(edges[f][0]+", "+edges[i][1] + " :" +max);
                printAll(n, edges, q, queries, edges[i], i, f, max, map);
            }
        }
    }
        static ArrayList<Integer> maximumWeight1(int n, int edges[][], int q, int queries[]) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int z = 0; z < q; z++) {
            System.out.println("****************");
            int test = queries[z];
            int i=edges[0][0];
            int count=0;
            while (i != n-1){

                queue.add(i);
                queue.add(0);
                while (!queue.isEmpty()) {
                    int k = queue.poll();
                    int j =queue.poll();
                    for ( ; j < n - 1; j++) {
                        if (edges[j][0] == k
                                //&& edges[j][2] <=test
                        ) {
                            //count++;
                            System.out.println(i+ ", "+edges[j][1]);
                            queue.add(edges[j][1]);
                            queue.add(j);
                        }
                    }
                    //if(queue.peek()==i)queue.poll();
                }

                i++;
            }
            res.add(count);
        }



        return res;
    }
    int ans;

    // Function to find the root of the given element in the disjoint set.
    private int root(int i, int[] parent) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    // Function to perform union operation of two sets and return the resulting size of the set.
    private int Union(int a, int b, int[] parent, int[] sz) {
        int ra = root(a, parent);
        int rb = root(b, parent);

        // If the roots are the same, it means they are already in the same set,
        // so return the current size of the set.
        if (ra == rb)
            return sz[ra] * sz[ra];

        // If the size of the set containing a is smaller than the size of the set containing b,
        // then swap a and b.
        if (sz[ra] < sz[rb]) {
            int temp = ra;
            ra = rb;
            rb = temp;

            temp = a;
            a = b;
            b = temp;
        }

        // Merge the two sets by updating the parent and size.
        ans += sz[ra] * sz[rb];
        parent[rb] = ra;
        sz[ra] += sz[rb];

        return ans;
    }

    ArrayList<Integer> maximumWeight(int n, int[][] edges, int q, int[] queries) {
        ans = 0;

        int[] parent = new int[n + 1];
        int[] sz = new int[n + 1];
        Arrays.fill(sz, 1);

        // Initializing each element as its own parent.
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // Creating a map to store the maximum weight of the connected component with weights less than or equal to each query.
        NavigableMap<Integer, Integer> mp = new TreeMap<>();

        // Sorting the edges based on their weights in ascending order.
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        // Iterating through the sorted edges and performing union operation.
        for (int i = 0; i < n - 1; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int c = edges[i][2];

            // Updating the map with the maximum weight of the connected component after each union operation.
            mp.put(c, Union(a, b, parent, sz));
        }

        // Creating a list to store the results for each query.
        ArrayList<Integer> res = new ArrayList<>();

        // Iterating through each query and finding the maximum weight with weights less than or equal to the query.
        for (int query : queries) {
            // Finding the element in the map which is just less than or equal to the query.
            Map.Entry<Integer, Integer> entry = mp.floorEntry(query);
            if (entry == null)
                res.add(0); // If there is no such element, then the maximum weight is 0.
            else
                res.add(entry.getValue()); // Storing the maximum weight for the query.
        }
        return res;
    }
}
