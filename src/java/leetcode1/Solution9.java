package leetcode1;

public class Solution9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome2(121));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }
        int copy = x;
        int sum = 0;
        while (copy > 0){
            sum = sum*10 + copy%10;
            copy = copy/10;
        }
        if(sum == x){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isPalindrome2(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0) ){
            return true;
        }
        int sum = 0;
        while (x > sum){
            sum = sum*10 + x%10;
            x = x/10;
        }
        return x == sum || sum/10 == x;
    }
}
