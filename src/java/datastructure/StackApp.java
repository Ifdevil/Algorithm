package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 栈的应用：括号匹配
 */
public class StackApp {

    private static Map<Character, Character> pair = null;

    public static void main(String[] args) {
        matchJudger();
        String str = "(2+4)*a[5]";
        System.out.println(MatchBrackets(str));
    }




    public static void matchJudger()
    {
        pair = new HashMap<Character, Character>();
        pair.put('(', ')');
        pair.put('{', '}');
        pair.put('[', ']');
    }

    public static boolean MatchBrackets(String str){
        boolean flag = false;
        if(str.length()==0){
            return flag;
        }
        char[] brackets = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < brackets.length; i++) {
            char ch = brackets[i];
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if(stack.empty()){
                        return false;
                    }
                    if(ch == pair.get(stack.peek())){
                        stack.pop();
                        flag = true;
                    }else {
                        return false;
                    }
            }
        }



        return flag;
    }
}
