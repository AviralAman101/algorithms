package in.algo.random;


import java.util.ArrayList;
import java.util.Stack;

/*
* Given a string str, the task is to find the bracket numbers, i.e.,
* for each bracket in str, return i if the bracket is the ith opening
* or closing bracket to appear in the string.

 Examples:

Input:  str = "(aa(bdc))p(dee)"
Output: 1 2 2 1 3 3
Explanation: The highlighted brackets in
the given string (aa(bdc))p(dee) are
assigned the numbers as: 1 2 2 1 3 3.
Input:  str = "(((()("
Output: 1 2 3 4 4 5
Explanation: The highlighted brackets in
the given string (((()( are assigned
the numbers as: 1 2 3 4 4 5
Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)

Constraints:
1 <= |str| <= 105
str contains lowercase English alphabets, and '(', ')' characters
At any index, the number of opening brackets is greater than or equal to closing brackets
*
* */
public class PrintBracketNumber {
    public static void main(String[] args) {
        System.out.println(bracketNumbers("((iy)rc(uv()(z((e())))u)()(()(())(e)((qb)(v((i))((pv))bw(uu)bg)))m()(l)(()(k)q)()(((n(n)))j)("));
    }
    private static ArrayList<Integer> bracketNumbers(String str) {
        ArrayList<Integer> result = new ArrayList<>(str.length());
        Stack<Integer> stack = new Stack<>();
        int openCount = 1;
        for (Character ch : str.toCharArray()){
            if(ch =='(') {
                result.add(openCount);
                stack.add(openCount++);
            }
            if(ch == ')') {
                result.add(stack.pop());
            }
        }
        return result;
    }
}

//1 2 2 3 4 4 5 6 7 8 8 7 6 5 3 9 9 10 11 11 12 13 13 12 14 14 15 16 16 17 18 19 19 18 20 21 21 20 22 22 17 15 10 23 23 24 24 25 26 26 27 27 25 28 28 29 30 31 32 32 31 30 29 33
