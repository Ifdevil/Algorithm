package leetcode2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution20 {

    public static void main(String[] args) {
        System.out.println(isValid("(])"));
    }

    public static boolean isValid(String s) {
        if(s == null || s.length()==0){
            return false;
        }
        Set<Character> set1 = new HashSet<Character>(){{
            add('(');
            add('[');
            add('{');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<s.length();i++){
            char c1 = s.charAt(i);
            if(set1.contains(c1)){
                stack.add(c1);
            }else{
                if(!stack.isEmpty()){
                    char c2 = stack.peek();
                    if((c1 == ')' && c2 == '(') || (c1 == ']' && c2 == '[') || c1 == '}' && c2 == '{'){
                        stack.pop();
                    }else {
                        return false;
                    }
                } else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
