package in.algo;


import java.util.ArrayList;
import java.util.List;

/*
* Given a string n, your task is to find whether it contains an additive sequence or not.
* A string n contains an additive sequence if its digits can make a sequence of numbers in
* which every number is addition of previous two numbers. You are required to complete the
* function which returns true if the string is a valid sequence else returns false.
* For better understanding check the examples.

Note: A valid string should contain at least three digit to make one additive sequence.

Example 1:

Input:
n = "1235813"
Output:
1
Explanation:
The given string can be splited into a series of numbers
where each number is the sum of the previous two numbers:
1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8, and 5 + 8 = 13. Hence, the output would be 1 (true).
Example 2:

Input:
n = "11235815"
Output:
0
Explanation:
We can start with the first two digits: "11".
First number: 1, Second number: 1, Sum: 1 + 1 = 2
Now, we have "2" as the next number.
First number: 1, Second number: 2, Sum: 1 + 2 = 3
Now, we have "3" as the next number.
First number: 2, Second number: 3, Sum: 2 + 3 = 5
Now, we have "5" as the next number.
First number: 3, Second number: 5, Sum: 3 + 5 = 8
Now, we have "8" as the next number.
First number: 5, Second number: 8, Sum: 5 + 8 = 13
At this point, there is no "13" present in the remaining digits "815". Hence, the output would be 0 (or false).
* */
public class AdditiveSequence {
    public static void main(String[] args) {
        System.out.println(isAdditiveSequence("1235813"));
        System.out.println(isAdditiveSequence("11235815"));
        System.out.println(isAdditiveSequence("14748"));
    }
    public static boolean isAdditiveSequence(String n) {
        // code here
        long l = n.length();
        boolean flag = false;
        if(l<3) return flag;
        for (int i = 1; i < l; i++) {
            for (int j = i+1; j < l; j++) {
                String a=n.substring(0, i);
                String b=n.substring(i, j);
                if(i>l-j || j > l-i) break;
                for (int k = j; k < l; ) {
                    int i4=0;
                    try {
                        int i2 = Integer.parseInt(a);

                    int i3 = Integer.parseInt(b);
                    i4 = i2 + i3;
                    }catch (Exception e){
                        break;
                    }
                    String i1 = String.valueOf(i4);
                    int len = i1.length();
                    if(k+len<=l && (n.substring(k, k+ len)).equals(i1)){
                        k+= len;
                        if(k== l){
                            flag=true;
                        }
                        a=b;
                        b=i1;
                    }else {
                        break;
                    }
                }
                if(flag) break;
            }
            if(flag) break;
        }

        return flag;
    }

    private class GFGSolution{ //0.05 seconds slower
        public boolean isAdditiveSequence(String s) {
            List<String> res = new ArrayList<>();
            int l = s.length();

            for (int i = 1; i <= l / 2; i++) {
                for (int j = 1; j <= (l - i) / 2; j++) {
                    if (checkAddition(res, s.substring(0, i), s.substring(i, i + j),
                            s.substring(i + j))) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean checkAddition(List<String> res, String a, String b, String c) {
            if (!isValid(a) || !isValid(b)) return false;
            String sum = addString(a, b);

            if (sum.equals(c)) {
                res.add(sum);
                return true;
            }

            if (c.length() <= sum.length() || !sum.equals(c.substring(0, sum.length())))
                return false;
            else {
                res.add(sum);
                return checkAddition(res, b, sum, c.substring(sum.length()));
            }
        }

        boolean isValid(String num) {
            if (num.length() > 1 && num.charAt(0) == '0') return false;
            return true;
        }

        int val(String a, int pos) {
            if (pos >= a.length() || pos < 0) return 0;
            return (a.charAt(pos) - '0');
        }

        String addString(String a, String b) {
            StringBuilder sum = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;

            while (i >= 0 || j >= 0) {
                int t = val(a, i) + val(b, j) + carry;
                sum.append(t % 10);
                carry = t / 10;
                i--;
                j--;
            }
            if (carry > 0) sum.append(carry);
            return sum.reverse().toString();
        }
    }
}
