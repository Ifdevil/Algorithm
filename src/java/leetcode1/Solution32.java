package leetcode1;

import java.util.Stack;

public class Solution32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }
    
    
    
    public static int longestValidParentheses(String s) {
        if(null == s || s.length() == 0){
            return 0;
        }
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
