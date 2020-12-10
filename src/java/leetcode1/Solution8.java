package leetcode1;

public class Solution8 {


    public static void main(String[] args) {
        System.out.println(myAtoi("   +0 123"));
    }

    public static int myAtoi(String str) {
        long sum = 0;
        boolean sign = false;
        boolean is = false;
        boolean n = true;
        boolean num = false;
        if(str.length() == 0){
            return 0;
        }
        for (int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == ' '){
                if(n){
                    continue;
                }else {
                    break;
                }
            }
            n = false;
            if(c == '-' && !is && !num){
                sign = true;
                is = true;
                continue;
            };
            if(c == '+' && !is && !num){
                is = true;
                continue;
            };
            if(c <48 || c>57){
                break;
            }
            num = true;
            sum = sum*10 + (c - 48);
            sum = sign ? -sum : sum;
            if(sum > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sum < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            sum = Math.abs(sum);
        }
        sum = sign ? -sum : sum;
        return (int)sum;
    }

    public static int myAtoi2(String str) {
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
}
