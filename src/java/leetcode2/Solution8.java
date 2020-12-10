package leetcode2;

import java.util.HashMap;
import java.util.Map;

public class Solution8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("+-12"));
    }

    public static int myAtoi(String str) {
        if(str.length() == 0)   return 0;
        //去除前面的空格
        int cur = 0;
        int res = 0;
        int sign = 1;
        while(cur < str.length() && str.charAt(cur) == ' ') cur++;
        if(cur == str.length()) return 0;
        if(str.charAt(cur) == '+'){
            sign = 1;
            cur++;
        }
        else if(str.charAt(cur) == '-'){
            sign = -1;
            cur++;
        }
        for(int i = cur; i < str.length(); i++){
            if(str.charAt(i) > '9' || str.charAt(i) < '0'){
                return sign * res;
            }
            int digit = str.charAt(i) - '0' ;
            if(sign > 0 && res > (Integer.MAX_VALUE - digit)/ 10)   return Integer.MAX_VALUE;
            if(sign < 0 && res!= 0 && res > (Integer.MIN_VALUE + str.charAt(i) - '0') / 10 * (-1))   return Integer.MIN_VALUE;
            res = res * 10 + digit;
        }
        return sign*res;
    }

    public static int myAtoi2(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}
class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}
