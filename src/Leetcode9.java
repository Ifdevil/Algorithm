/**
 * leetcode 9 判断整数回文
 */
public class Leetcode9 {


    public static void main(String[] args) {
        System.out.println(isPalindrome2(121));
    }

    /**
     * 反转整数------可能溢出
     * @param x
     * @return
     */
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

    /**
     * 反转后半部分和前半部分对比
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if(x<0){
            return false;
        }
        if(x>=0  && x<10){
            return true;
        }
        int rev = 0;
        int old = x;
        while (x!= 0 && rev*10<x){
            int pop = x % 10;
            x /= 10;
            rev = rev*10 + pop;
        }
        return rev==x || rev/10 == x;

    }
}
