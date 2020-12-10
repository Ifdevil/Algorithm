package leetcode1;

import java.util.Map;
import java.util.Stack;

public class Solution20 {

    public static void main(String[] args) {
        System.out.println(isValid("){"));
    }

    public static boolean isValid(String s) {
        if(null == s || s.length()% 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if( c == '{' || c == '(' || c=='['){
                stack.push(c);
            }else {
                if(stack.size()>0){
                    if(c == '}'){
                        char p = stack.peek();
                        if(p != '{'){
                            return false;
                        }
                        stack.pop();
                    } else
                    if(c == ')'){
                        char p = stack.peek();
                        if(p != '('){
                            return false;
                        }
                        stack.pop();
                    } else
                    if(c == ']'){
                        char p = stack.peek();
                        if(p !='['){
                            return false;
                        }
                        stack.pop();
                    }
                }else {
                    return false;
                }
            }
        }
        return stack.size() <= 0;
    }
}
