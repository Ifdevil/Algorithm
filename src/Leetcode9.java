/**
 * leetcode 10 判断整数回文
 */
public class Leetcode9 {


    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x>=0  && x<10){
            return true;
        }
        int rev = 0;
        int old = x;
        while (x!= 0){
            int pop = x % 10;
            x /= 10;
            rev = rev*10 + pop;
        }
        if(old==rev) return true;

        return false;
    }
}
