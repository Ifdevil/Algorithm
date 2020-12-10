package leetcode2;

import java.util.HashSet;
import java.util.Set;

public class Solution202 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        if(n == 1){
            return true;
        }
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)){
            seen.add(n);
            int sum = 0;
            while ( n/10 > 0){
                sum += Math.pow(n%10,2);
                n = n /10;
            }
            sum += Math.pow(n,2);
            n = sum;
        }
        return n==1;
    }
}
