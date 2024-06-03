package in.algo;


/*
* Given a binary representation in the form of a string(s) of a number n, the task is to find a
* binary representation of n+1.

Example 1:

Input: s = "10"
Output: 11
Explanation: "10" is the binary representation of 2 and binary representation of 3 is "11"
Example 2:

Input: s = "111"
Output: 1000
Explanation: "111" is the binary representation of 7 and binary representation of 8 is "1000"
Your Task:
You don't need to read input or print anything. Complete the function binaryNextNumber()
* which takes s as input parameter and returns the string.
*
* */

public class BinaryRepresentationOfNextNumber {
    public static void main(String[] args) {
        System.out.println(binaryNextNumber("11111100"));
        System.out.println(binaryNextNumber("111"));
        System.out.println(binaryNextNumber("111101"));
    }

    private static String binaryNextNumber(String s) {
        char[] charArray = s.toCharArray();
        int i;
        for (i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == '1')
                charArray[i] = '0';
            else {
                charArray[i] = '1';
                break;
            }
        }
        if (i == -1) return "1" + new String(charArray);
        boolean flag = true;
        StringBuilder sb = new StringBuilder(charArray.length);
        for (int j = 0; j < charArray.length; j++) {
            if (flag && charArray[j] == '0') {
                continue;
            } else {
                flag = false;
                sb.append(charArray[j]);
            }
        }
        return sb.toString();
    }
}
