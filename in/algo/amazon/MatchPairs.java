package in.algo.amazon;


import java.util.Arrays;

/*
* Given a set of n nuts & bolts. There is a one-on-one mapping between nuts and bolts. You have to Match nuts and bolts efficiently. Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means the nut can only be compared with the bolt and the bolt can only be compared with the nut to see which one is bigger/smaller.
The elements should follow the following order: { !,#,$,%,&,*,?,@,^ }

Note: Make all the required changes directly in the given arrays, output will be handled by the driver code.

Examples

Input: n = 5, nuts[] = {@, %, $, #, ^}, bolts[] = {%, @, #, $ ^}
Output:
# $ % @ ^
# $ % @ ^
Explanation: As per the order # should come first after that $ then % then @ and ^.
Input: n = 9, nuts[] = {^, &, %, @, #, *, $, ?, !}, bolts[] = {?, #, @, %, &, *, $ ,^, !}
Output:
! # $ % & * ? @ ^
! # $ % & * ? @ ^
Explanation: We'll have to match first ! then  # , $,  %,  &,  *,  @,  ^,  ? as per the required ordering.
* */
public class MatchPairs {
    public static void main(String[] args) {
        matchPairs(5, new char[]{'@', '%', '$', '#', '^'}, new char[]{'%', '@', '#', '$', '^'});
    }
    static void matchPairs(int n, char nuts[], char bolts[]) {
        // Initialize an array c to store the count of different characters
        int c[] = new int[n];
        // Initialize variables i, j, and k
        int i, j = 0, k;
        // Initialize a hash array h to store frequency of characters (size 256 for
        // ASCII)
        int h[] = new int[256];
        // Calculate frequency of characters in array a and store in hash array h
        for (i = 0; i < n; i++) {
            h[nuts[i]]++;
        }
        // Iterate over the hash array to get unique characters and store in arrays a
        // and b
        for (i = 0; i < 256; i++) {
            if (h[i] > 0) {
                // Assign character i to arrays a and b
                nuts[j] = (char)i;
                bolts[j++] = (char)i;
            }
        }
    }

    static void matchPairsUsingJDK17Switch(int n, char nuts[], char bolts[]) {
        // code here
        String order = "!#$%&*?@^";
        int[] chars = new int[9];
        for (int i = 0; i < n; i++) {
            switch (nuts[i]){
                case '!' -> chars[0]++;
                case '#' -> chars[1]++;
                case '$' -> chars[2]++;
                case '%' -> chars[3]++;
                case '&' -> chars[4]++; //String order = "!#$%&*?@^";
                case '*' -> chars[5]++;
                case '?' -> chars[6]++;
                case '@' -> chars[7]++;
                case '^' -> chars[8]++;
            }
        }
        int k=0;
        for (int i = 0; i < 9; i++) {
            if(chars[i] == 0) continue;
            switch (i){
                case 0 -> {
                    nuts[k] = '!';
                    bolts[k] = '!';
                }
                case 1 -> {
                    nuts[k] = '#';
                    bolts[k] = '#';
                }
                case 2 -> {
                    nuts[k] = '$';
                    bolts[k] = '$';
                }
                case 3 ->  {
                    nuts[k] = '%';
                    bolts[k] = '%';
                }
                case 4 ->  {
                    nuts[k] = '&';
                    bolts[k] = '&';
                } //String order = "!#$%&*?@^";
                case 5 ->  {
                    nuts[k] = '*';
                    bolts[k] = '*';
                }
                case 6 ->  {
                    nuts[k] = '?';
                    bolts[k] = '?';
                }
                case 7 ->  {
                    nuts[k] = '@';
                    bolts[k] = '@';
                }
                case 8 ->  {
                    nuts[k] = '^';
                    bolts[k] = '^';
                }
            }
            k++;
        }
        System.out.println(Arrays.toString(nuts));
    }
}
