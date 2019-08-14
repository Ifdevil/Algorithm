/**
 * leetcode12
 */
public class Leetcode12 {

    static int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {


        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index<13){
            while (num >= nums[index]){
                int count = num / nums[index];
                for (int i = 0; i < count; i++) {
                    sb.append(romans[index]);
                }
                num = num % nums[index];
            }
            index++;
        }

        return sb.toString();

    }
}
