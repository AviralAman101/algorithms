package in.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* Given a positive integer n. Your task is to generate a string list of all n-bit binary
* numbers where, for any prefix of the number, there are more or an equal number of 1's than 0's.
* The numbers should be sorted in decreasing order of magnitude.

Example 1:

Input:
n = 2
Output:
"11, 10"
Explanation: Valid numbers are those where each prefix has more 1s than 0s:
11: all its prefixes (1 and 11) have more 1s than 0s.
10: all its prefixes (1 and 10) have more 1s than 0s.
So, the output is "11, 10".
Example 2:

Input:
n = 3
Output:
"111, 110, 101"
Explanation: Valid numbers are those where each prefix has more 1s than 0s.
111: all its prefixes (1, 11, and 111) have more 1s than 0s.
110: all its prefixes (1, 11, and 110) have more 1s than 0s.
101: all its prefixes (1, 10, and 101) have more 1s than 0s.
So, the output is "111, 110, 101".
* */
public class NBitBinaryPrefix {
    static Map<Integer, Integer> mp = new HashMap<>();
    public static void main(String[] args) {
        //ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> strings1 = NBitBinary(3);
        System.out.println(strings1);
    }
    static ArrayList<String> NBitBinary(int N) {
        // code here
        int start=(int) Math.pow(2, N-1);
        int end = (int) Math.pow(2, N);
        int total = end-start;
        ArrayList<String> list = new ArrayList<>();
        for (int i = end-1; i >= start; i--) {
            decimalToBinary(i, list);
        }
        return list;
    }

    // Function converting decimal to binary
    public static void decimalToBinary(int num, ArrayList<String> list)
    {
        // Creating and assigning binary array size
        //int x=num;
        //int[] binary = new int[35];
        int id = 0;
        String x=Integer.toBinaryString(num);
        boolean flag=true;
        for (int i = 0; i < x.length(); i++) {
            if(x.charAt(i)=='1') id++;
            if(id*2 < i+1){
                flag=false;
                break;
            }
        }
        if(flag) list.add(x);
    }

}
