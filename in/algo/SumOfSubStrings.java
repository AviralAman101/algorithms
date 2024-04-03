package in.algo;


import java.util.Arrays;

/*
* Given an integer s represented as a string, the task is to get the sum of all possible sub-strings of this string.
As the answer will be large, return answer modulo 109+7.

Example 1:

Input:
s = "1234"
Output:
1670
Explanation:
Sum = 1 + 2 + 3 + 4 + 12 + 23 + 34 + 123 + 234 + 1234 = 1670
Example 2:

Input:
s = "421"
Output:
491
Explanation:
Sum = 4 + 2 + 1 + 42 + 21 + 91 + 421 = 491
* */
public class SumOfSubStrings {
    public static void main(String[] args) {
        String number = "4949530612642323625417080671";
        String number1 = "1234";
        long l = sumSubstrings(number1);
        long l1 = sumSubstrings(number);
        System.out.println(l);
        System.out.println(l1);
    }

    public static long sumSubstrings(String s)
    {
        int ls = s.length();
        long[] sumOfDigit = new long[ls];
        int mod = 1000000007;
        //int num[] = new int[ls];
        //num[0]=s.charAt(0) - '0';
        sumOfDigit[0]=s.charAt(0) - '0';
        long sum=0;

        for (int i = 1; i < ls; i++) {
            int num=(int) (s.charAt(i) - '0');
            sumOfDigit[i] = (((i+1)*(num))%mod+(sumOfDigit[i-1]*10)%mod)%mod;

        }
//        }
//        String s1 = Arrays.toString(sumOfDigit);
//        int sum1 = Arrays.stream(sumOfDigit).sum();
        for (int i = 0; i < sumOfDigit.length; i++) {
            sum=(sum+sumOfDigit[i])%mod;
        }
        return sum;
    }
}
