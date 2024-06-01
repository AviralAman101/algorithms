package in.algo.amazon;


import java.util.ArrayList;
import java.util.Collections;

/*
* Given a list s that initially contains only a single value 0. There will be q queries of the following types:

0 x: Insert x in the list
1 x: For every element a in s, replace it with a ^ x. ('^' denotes the bitwise XOR operator)
Return the sorted list after performing the given q queries.

Example 1:

Input:
q = 5
queries[] = {{0, 6}, {0, 3}, {0, 2}, {1, 4}, {1, 5}}
Output:
1 2 3 7
Explanation:
[0] (initial value)
[0 6] (add 6 to list)
[0 6 3] (add 3 to list)
[0 6 3 2] (add 2 to list)
[4 2 7 6] (XOR each element by 4)
[1 7 2 3] (XOR each element by 5)
The sorted list after performing all the queries is [1 2 3 7].
Example 2:
Input:
q = 3
queries[] = {{0, 2}, {1, 3}, {0, 5}}
Output :
1 3 5
Explanation:
[0] (initial value)
[0 2] (add 2 to list)
[3 1] (XOR each element by 3)
[3 1 5] (add 5 to list)
The sorted list after performing all the queries is [1 3 5].

Your Task:
You don't need to read input or print anything. Your task is to complete the function constructList() which takes an integer q the number of queries and queries[] a list of lists of length 2 denoting the queries as input parameters and returns the final constructed list.


* */
public class ConstructXORList {

    public static void main(String[] args) {
        System.out.println(constructList(3, new int[][]{{0, 2}, {1, 3}, {0, 5}}));
    }

    public static ArrayList<Integer> constructList(int q, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        int XOR = -1;

        for (int i = q-1; i >= 0; i--) {
            int[] query = queries[i];
            if(query[0]==1){
                if(XOR == -1) XOR = query[1];
                else XOR ^= query[1];
            }else {
                if(XOR != -1) result.add(XOR^query[1]);
                else result.add(query[1]);
            }
        }
        if(XOR != -1) result.add(XOR^0);
        else result.add(0);
        Collections.sort(result);
        return result;
    }
}
