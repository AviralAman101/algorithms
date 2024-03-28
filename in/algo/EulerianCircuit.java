package in.algo;

import java.util.*;

/*
* Eulerian Path is a path in a graph that visits every edge exactly once.
* Eulerian Circuit is an Eulerian Path that starts and ends on the same vertex.
* Given the number of vertices v and adjacency list adj denoting the graph.
* Find that there exists the Euler circuit or not. Return 1 if there exist
* alteast one eulerian path else 0.

Note that: Given graph is connected.

Example 1:

Input:
v = 4
edges[] = {{0, 1},
           {0, 2},
           {1, 3},
           {2, 3}}

Output:
1
Explanation: corresponding adjacency list will be {{1, 2},{0, 3},{0, 3},{1, 2}}
One of the Eularian circuit
starting from vertex 0 is as follows:
0->1->3->2->0
Example 2:

Input:
v = 3
edges[] = {{0, 1},
         {0, 2}}


Output:
0
Explanation: corresponding adjacency list will be {{1, 2}}
No Eulerian path is found.
* */
public class EulerianCircuit {
    public static void main(String[] args) {

        System.out.println(isEularCircuitExist(4, init2()));
    }
    /*edges[] = {{0, 1},
         {0, 2}}*/
    private static ArrayList<ArrayList<Integer>> init3(){
        ArrayList<Integer> li = new ArrayList<>();
        li.add(0);
        li.add(1);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(2);
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(li);
        arrayLists.add(l2);
        return arrayLists;
    }

    /*{{0, 1},
           {0, 2},
           {1, 3},
           {2, 3}}*/
    private static ArrayList<ArrayList<Integer>> init2(){
        /*4 4
0 1
0 2
1 3
2 3
        * */
        ArrayList<Integer> li = new ArrayList<>();
        li.add(4);
        li.add(4);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(1);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(2);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(1);
        l4.add(3);
        ArrayList<Integer> l5 = new ArrayList<>();
        l5.add(2);
        l5.add(3);
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(li);
        arrayLists.add(l2);
        arrayLists.add(l3);
        arrayLists.add(l4);
        arrayLists.add(l5);
        return arrayLists;
    }
    private static ArrayList<ArrayList<Integer>> init(){
        ArrayList<Integer> li = new ArrayList<>();
        li.add(0);
        li.add(1);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(2);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(3);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(2);
        l4.add(3);
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(li);
        arrayLists.add(l2);
        arrayLists.add(l3);
        arrayLists.add(l4);
        return arrayLists;
    }

    public static boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Map<Integer, Set<Integer>> ss = new HashMap<>();
        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> in = adj.get(i);
            Integer i1 = in.get(0);
            Integer i2 = in.get(1);
            if(Integer.compare(i1, i2)==0) continue;
            Set<Integer> s1 = ss.get(i1);
            if(s1 == null){
                HashSet<Integer> t = new HashSet<>();
                t.add(i2);
                ss.put(i1,t );
            }else s1.add(i2);
            Set<Integer> s2 = ss.get(i2);
            if(s2 == null){
                HashSet<Integer> t = new HashSet<>();
                t.add(i1);
                ss.put(i2,t );
            }else s2.add(i1);
        }
        System.out.println(ss);
        for (Map.Entry<Integer, Set<Integer>> kv : ss.entrySet()){
            if(kv.getValue().size()<2)
                return false;
        }
        return true;
    }

}
