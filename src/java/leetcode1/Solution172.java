package leetcode1;

public class Solution172 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(50));
    }

    public static int trailingZeroes(int n) {
        int num2 = 0;
        while (n>0){
            num2 += n/5;
            n = n/5;
        }
        return  num2;
    }
}
