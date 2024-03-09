package in.algo;

import java.util.Arrays;

/*
* Given a binary string s. Perform r iterations on string s, where in each iteration 0 becomes 01 and 1 becomes 10.
* Find the nth character (considering 0 based indexing) of the string after performing these r iterations (see examples
* for better understanding).

Example 1:

Input:
s = "1100"
r = 2
n = 3
Output:
1
Explanation:
After 1st iteration s becomes "10100101".
After 2nd iteration s becomes "1001100101100110".
Now, we can clearly see that the character at 3rd index is 1, and so the output.
Example 2:

Input:
s = "1010"
r = 1
n = 2
Output:
0
Explanation :
After 1st iteration s becomes "10011001".
Now, we can clearly see that the character at 2nd index is 0, and so the output.*/
public class FindNthCharacterInBinaryString {

    public static void main(String[] args) {
        System.out.println(nthCharacter("1100",2,3));
    }

    public static char nthCharacter(String s, int r, int n)
    {

        int chToFind = (int) (n / (Math.pow(2, r)));
        int ind = (int)(n - chToFind*Math.pow(2,r));
        String ch = String.valueOf(s.charAt(chToFind));
        while (r!=0){
            String a="";
            for (int j = 0; j < ch.length(); j++) {
                if(ch.charAt(j)=='0') {
                    a+="01";
                    //System.out.print("01");
                }
                else {
                    a+="10";
                    //System.out.print("10");
                }
            }
            ch=a;
            r--;
            if(ch.length()>ind)
                return ch.charAt(ind);
        }
        return ' ';
    }
}
