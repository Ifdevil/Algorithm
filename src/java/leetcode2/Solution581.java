package leetcode2;

import java.util.Arrays;

public class Solution581 {

    public static void main(String[] args) {
        
    }

    public int findUnsortedSubarray(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        int left = nums.length;
        int right = 0;
        for (int i = 0;i<nums.length-1;i++){
            for (int j = i+1;j<nums.length;j++){
                if(nums[j] < nums[i]){
                    left = Math.min(left,i);
                    right = Math.max(right,j);
                }
            }
        }
        return Math.max(right - left+1, 0);
    }

    public int findUnsortedSubarray1(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }
}
