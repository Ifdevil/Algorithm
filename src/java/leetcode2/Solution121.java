package leetcode2;

public class Solution121 {

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        if(null == prices || prices.length==0){
            return profit;
        }
        int min = prices[0];
        for (int i = 1;i<prices.length;i++){
            // 这里每次都要计算，效率低了
            profit = Math.max(profit,prices[i]-min);
            min = Math.min(prices[i],min);
            // 优化版本
//            if(prices[i] < min){
//                min = prices[i];
//            }else if(profit < prices[i] - min){
//                profit = prices[i] - min
//            }
        }
        return profit;
    }
}
