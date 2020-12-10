package leetcode1;

import java.util.Arrays;

public class Solution34 {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(Arrays.toString(searchRange(nums, 1)));
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result,-1);
        if(null == nums || nums.length == 0){
            return result;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = (low + high)/2;
            int index = nums[mid];
            if(index == target){
                int copy = mid;
                while ( (--copy)>=0 && nums[copy] == target){
                }
                result[0] = copy+1;
                copy = mid;
                while (++copy <= nums.length-1 && nums[copy] == target){
                }
                result[1] = copy-1;
                return result;
            }
            if(index > target){
                high = mid - 1;
            }
            if(index < target){
                low = mid + 1;
            }
        }
        return result;
    }
}
