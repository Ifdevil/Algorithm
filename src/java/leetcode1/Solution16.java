package leetcode1;

import java.util.Arrays;

public class Solution16 {

    public static void main(String[] args) {
        System.out.println(Math.abs(10^4));
        int[] nums = {0,1,2};
        System.out.println(threeSumClosest(nums,0));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if(nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int result = 10000000;
        for (int i = 0;i<len;i++){
            int value = nums[i];
            int left = i+1;
            int right = len - 1;
            while (left < right){
                int sum = value + nums[left] + nums[right];
                if(sum == target){
                    return target;
                }
                result = Math.abs(target-sum) < Math.abs(target - result) ? sum:result;
                if(sum > target){
                    right--;
                }
                if(sum < target){
                    left++;
                }
            }
        }
        return result;
    }
}
