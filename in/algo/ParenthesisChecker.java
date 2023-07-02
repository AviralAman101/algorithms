package in.algo;

import java.util.Stack;

//Given an expression string x.
// Examine whether the pairs and the orders of {,},(,),[,] are correct in exp.
//For example, the function should return 'true' for exp = [()]{}{[()()]()} 
// and 'false' for exp = [(]).

public class ParenthesisChecker {
    public static void main(String[] args) {
        System.out.println(ispar(")"));
    }
    static boolean ispar(String x)
    {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if(c == '[' || c == '{' || c == '('){
                stk.push(c);
            }else {
                if(c == ']' && !stk.empty() && stk.peek() == '[')
                    stk.pop();
                else if (c == '}' && !stk.empty() && stk.peek()=='{') {
                    stk.pop();
                } else if (c == ')' && !stk.empty() && stk.peek() == '(') {
                    stk.pop();
                }else return false;
            }
        }
        if(stk.empty())
            return true;
        return false;    }
}
