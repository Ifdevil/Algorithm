package leetcode2;

public class Solution9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));   
    }

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int sum = 0;
        int num = x;
        while (x>0){
            int temp = x%10;
            x = x/10;
            sum = sum*10+temp;
        }
        return sum==num;
    }
}
