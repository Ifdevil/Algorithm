package leetcode1;

import java.util.Stack;

public class Solution224 {
    
    public static void main(String[] args) {
        
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0; // For the on-going result
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // 操作数
                operand = 10 * operand + (int) (ch - '0');
                
            } else if (ch == '+') {
                result += sign * operand;
                // 加号为正 1
                sign = 1;
                // 重置操作数
                operand = 0;
            } else if (ch == '-') {
                result += sign * operand;
                // 负号为-1
                sign = -1;
                // 重置操作数
                operand = 0;
            } else if (ch == '(') {
                // 前面的结果压栈
                stack.push(result);
                // 计算符号压栈
                stack.push(sign);
                // 重置正负标识和result，开始计算子表达式
                sign = 1;
                result = 0;

            } else if (ch == ')') {
                // 子表达式的值
                result += sign * operand;
                // 弹出正负号，乘即可
                result *= stack.pop();
                // 弹出上个表达式的值，相加（结合律）
                result += stack.pop();
                operand = 0;
            }
        }
        return result + (sign * operand);
    }
}
