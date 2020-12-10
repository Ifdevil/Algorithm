package leetcode2;

public class Solution7 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        if(x < 10 && x > -10){
            return x;
        }
        boolean flag = x < 0;
        x = Math.abs(x);
        long temp = 0;
        while (x > 0){
            temp = temp*10+x%10;
            if(temp > Integer.MAX_VALUE){
                return 0;
            }
            x = x/10;
        }
        return flag ? (int) -temp : (int) temp;
    }
}
