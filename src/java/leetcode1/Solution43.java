package leetcode1;

public class Solution43 {

    public static void main(String[] args) {
        System.out.println(multiply("123456789","987654321"));
    }

    public static String multiply(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int end1 = num1.length()-1;
        int end2 = num2.length()-1;
        String sum = "";
        for (int i = end2;i>=0;i--){
            String s = "";
            int c1 = 0;
            for (int j = end2; j > i; j--) {
                s = s + "0";
            }
            int c2 = num2.charAt(i) - '0';
            for (int j = end1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * c2 + c1;
                s = product%10 + s;
                c1 = product / 10;
            }
            if(c1!=0){
                s = c1%10 + s;
            }
            sum = add(sum,s);
        }
        return sum;
    }
    
    private static String add(String num1,String num2){
        int end1 = num1.length()-1;
        int end2 = num2.length()-1;
        String sum = "";
        int pre = 0;
        while (end1 >= 0 && end2 >= 0){
            char c1 = num1.charAt(end1);
            char c2 = num2.charAt(end2);
            int c3 = (c1 - '0')+(c2 - '0') + pre;
            sum = c3%10 + sum;
            pre = c3/10;
            end1--;
            end2--;
        }
        while (end1 >= 0){
            char c1 = num1.charAt(end1);
            int c2 = c1 - '0'+pre;
            sum = c2%10 + sum;
            pre = c2/10;
            end1--;
        }
        while (end2 >= 0){
            char c1 = num2.charAt(end2);
            int c2 = c1 - '0'+pre;
            sum = c2%10 + sum;
            pre = c2/10;
            end2--;
        }
        if(pre>0){
            sum = pre+sum;
        }
        return sum;
    }
}
