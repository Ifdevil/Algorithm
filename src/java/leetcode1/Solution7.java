package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Solution7 {

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        long sum = 0;
        while (x != 0){
            sum = sum*10 +x % 10;
            if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
                return 0;
            }
            x = x / 10;
        }
        return (int)sum;
    }
}
