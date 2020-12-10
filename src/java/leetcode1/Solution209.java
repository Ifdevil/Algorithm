package leetcode1;

import java.util.Arrays;

public class Solution209 {

    public static void main(String[] args) {
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        int s = 213;
        System.out.println(minSubArrayLen(s,nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int minSub = Integer.MAX_VALUE;
        for (;end<len;end++){
            sum += nums[end];
            if(sum >= s){
                minSub = Math.min(minSub,(end-start+1));
                sum = sum - nums[end] - nums[start];
                start = start+1;
                end = end-1;
            }
        }
        return minSub == Integer.MAX_VALUE?0:minSub;
    }

    public static int minSubArrayLen1(int s, int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        Arrays.sort(nums);
        int minSub = 0;
        int sum = 0;
        for (int i = len-1;i>=0;i--){
            sum += nums[i];
            if(sum >= s){
                minSub = len-i;
                return minSub;
            }
        }
        return 0;
    }
}
