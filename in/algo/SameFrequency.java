package in.algo;

import java.util.Arrays;
import java.util.Comparator;

/*
* Given a string s which contains only lower alphabetic characters, check if it is possible to remove at most one
* character from this string in such a way that frequency of each distinct character becomes same in the string.
* Return true if it is possible to do else return false.

Note: The driver code print 1 if the value returned is true, otherwise 0.

Example 1:

Input:
s = "xyyz"
Output:
1
Explanation:
Removing one 'y' will make frequency of each character to be 1.
Example 2:

Input:
s = "xxxxyyzz"
Output:
0
Explanation:
Frequency can not be made same by removing at most one character.
Your Task:
You dont need to read input or print anything. Complete the function sameFreq() which takes a string as input parameter
* and returns a boolean value denoting if same frequency is possible or not.*/
public class SameFrequency {
    public static void main(String[] args) {
        System.out.println(sameFreq("xxyyz"));
        System.out.println(sameFreq("aaabbb"));
    }
    static boolean sameFreq(String s) {
        int sl = s.length();
        if(sl <=1) return true;
        int[] ints = new int[26];
        int index;
        char[] chars = s.toCharArray();
        for (int i = 0; i < sl; i++) {
            index = ((int) chars[i])-97;
            ints[index]+=1;
        }
        Arrays.sort(ints);
        if(ints[25]-1 == ints[24])
            ints[25]-=1;
        else {
            int x=25;
            while (ints[x] != 0 && x !=1){
                x--;
                if(ints[x]==0 && x<24 && (ints[x+2] == ints[x+1]-1 || ints[x+1]-1==0))
                    ints[x+1]-=1;
            }
        }
        for (int i = 25; i > -1; i--) {
            if(ints[25] != ints[i] && ints[i] !=0)
                return false;
        }
        return true;
    }
}
