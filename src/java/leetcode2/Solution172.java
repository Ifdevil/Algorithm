package leetcode2;

public class Solution172 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(50));
    }

    public static int trailingZeroes(int n) {
        if(n == 0){
            return 0;
        }
        int count = 0;
        int v1 = 0;
        while (n>0){
            if(n%5==0){
                int v3 = n;
                while (v3 % 5 == 0){
                    v1 = v1 + 1;
                    v3 = v3/5;
                }
            }
            n--;
        }
        return count+v1;
    }
}
