package leetcode1;

public class Solution121 {

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0){
            return 0;
        }
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0;i < len;i++){
            if(prices[i] > min){
                profit = Math.max(prices[i] - min,profit);
            }
            if(prices[i] < min){
                min = prices[i];
            }
        }
        return profit;
    }
}
