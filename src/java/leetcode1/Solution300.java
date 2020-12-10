package leetcode1;

public class Solution300 {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1;i<n;i++){
            int init = 0;
            for (int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    init = Math.max(init,dp[j]);
                }
            }
            dp[i] = init+1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
