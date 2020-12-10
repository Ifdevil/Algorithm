package leetcode2;

public class Solution69 {

    public static void main(String[] args) {
        System.out.println(Sqrt(5));
        System.out.println(2.2360658645629883*2.2360658645629883);
    }
    
    public static double Sqrt(int num){
        double right = num;
        double left = 0d;
        double mid = (left+right)/2;
        double p = 0.00001;
        while (Math.abs((mid*mid - num)) > p){
            if(mid*mid<num){
                left = mid;
            }else if(mid*mid>num){
                right = mid;
            }else {
                return mid;
            }
            mid = (left + right)/2;
        }
        return mid;
    }
}
