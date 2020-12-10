package leetcode1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Solution316 {

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("mnmnabcnm"));
    }

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set = new HashSet<Character>();
        HashMap<Character,Integer> last = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            last.put(s.charAt(i),i);
        }
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                while (!stack.isEmpty() && c < stack.peek() && last.get(stack.peek())>i){
                    set.remove(stack.pop());
                }
                set.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) sb.append(c.charValue());
        return sb.toString();
    }
}
