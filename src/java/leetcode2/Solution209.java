package leetcode2;

public class Solution209 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int min = nums.length + 1;
        for (int i = 0;i<nums.length;i++){
            int sum = nums[i];
            if(sum >= s){
                return 1;
            }
            for (int j = i+1;j<nums.length;j++){
                sum += nums[j];
                if(sum >= s){
                    min = Math.min(j-i+1,min);
                    break;
                }
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
