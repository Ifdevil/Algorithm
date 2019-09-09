import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 */
public class Leetcode20 {


    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        Map<Character,Character> map = new HashMap();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty()){
                if(map.get(s.charAt(i))==stack.peek()){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();

    }

}
