package leetcode2;

public class Solution258 {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        if(num<10){
            return num;
        }
        int sum = 0;
        while (num>0){
            sum = sum+num%10;
            num = num/10;
        }
        return addDigits(sum);
    }
}
