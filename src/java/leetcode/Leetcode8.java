package leetcode;;

/**
 * leetcode8 字符串转换整数 (atoi)
 */
public class Leetcode8 {


    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483649"));
    }

    public static int myAtoi(String str) {
        if(str.length() == 0){
            return 0;
        }

        boolean flag = false;
        int j = 0;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i)<='9'){
                j = i;
                break;
            }
            if(str.charAt(i) == '-'){
                if(str.charAt(i) =='-') flag = true;
                if(str.length()==1) return 0;
                j = ++i;
                break;
            }
            if(str.charAt(i) != ' '){
                return 0;
            }
        }

        int k = 0;
        for (int i = j; i < str.length() ; i++) {
            if(str.charAt(i) >= '0' && str.charAt(i)<='9'){
                k = i+1;
            }else {
                break;
            }
        }
        int result = 0;

        if(k>=j){
            str = str.substring(j,k);

            for (int i = 0; i < str.length(); i++) {
                if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE /10 &&(int) (str.charAt(i) - '0')>7)) return Integer.MAX_VALUE;
                if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && (int) (str.charAt(i) - '0') > 8)) return Integer.MIN_VALUE;
                if(flag){
                    result = result * 10 - (int) (str.charAt(i) - '0');
                }else{
                    result = result * 10 + (int) (str.charAt(i) - '0');
                }
            }
        }

        return result;
    }
}
