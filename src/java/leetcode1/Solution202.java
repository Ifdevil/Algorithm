package leetcode1;

public class Solution202 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        int start = n;
        int next = n;
        while (next != 1){
            start = getNext(start);
            next = getNext(getNext(next));
            if(start == next){
                break;
            }
        }
        return next == 1;
    }
    
    private static int getNext(int n){
        int next = 0;
        while (n > 0){
            int j = n % 10;
            n = n/10;
            next += j*j;
        }
        return next;
    }
}
