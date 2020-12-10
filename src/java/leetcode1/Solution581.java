package leetcode1;

public class Solution581 {

    public static void main(String[] args) {
        int[] nums = {1,2,5,4,3};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int len = 0;
        for (int i = 1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                start = Math.min(start,i-1);
                end = i;
                // 向前追溯
                while (start-1>0 && (nums[start] == nums[start-1]||nums[i]<nums[start-1])){
                    start--;
                }
                // 向后追溯
                while (end+1<nums.length && ( nums[end] == nums[end+1]||nums[i]>nums[end+1])){
                    end++;
                }
                len = end - start +1;
            }
        }
        return len;
    }
}
