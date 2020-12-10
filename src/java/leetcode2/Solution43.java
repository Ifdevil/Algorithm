package leetcode2;

public class Solution43 {

    public static void main(String[] args) {
        System.out.println(multiply("123","456"));
    }

    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        String sum = "";
        for (int i = len2;i>=0;i--){
            StringBuilder s = new StringBuilder();
            for (int j = len2;j>i;j--){
                s.append("0");
            }
            int c1 = 0;
            int c2 = num2.charAt(i) -'0';
            for (int k = len1;k>=0;k--){
                int c3 = num1.charAt(k) - '0';
                int temp = c2 * c3;
                s.insert(0, (temp + c1) % 10);
                c1 = (temp + c1)/10;
            }
            if(c1>0){
                s.insert(0,c1);
            }
            sum = add(sum,s.toString());    
        }
        return sum;
    }
    
    private static String add(String num1,String num2){
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int add = 0;
        String sum = "";
        while (len1 >= 0 || len2 >= 0 || add != 0){
            int i = len1>=0 ? num1.charAt(len1)-'0':0;
            int j = len2>=0 ? num2.charAt(len2)-'0':0;
            int t = i+j+add;
            sum = t%10+sum;
            add = t/10;
            len1--;
            len2--;
        }
        return sum;
    }
}
