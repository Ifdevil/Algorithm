package leetcode1;

public class Solution53 {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray1(nums));
    }

    public static int maxSubArray(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[n][n];
        for (int i = 0;i<nums.length;i++){
            for (int j = 0;j<nums.length-i;j++){
                int k = i + j;
                if(i == 0){
                    dp[j][i] = nums[k];
                }else {
                    dp[j][i] = nums[k] + dp[j][i-1];
                }
                ans = Math.max(ans,dp[j][i]);
            }
        }
        return ans;
    }

    public static int maxSubArray1(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int ans = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1;i<nums.length;i++){
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    
    public static int maxSubArray2(int[] nums){
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
