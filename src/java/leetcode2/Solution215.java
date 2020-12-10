package leetcode2;

import java.util.Arrays;

public class Solution215 {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(findKthLargest1(nums,1));
    }

    public static int findKthLargest(int[] nums, int k) {
        if(null == nums){
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    
    public static int findKthLargest1(int[] nums,int k){
        int low = 0;
        int high = nums.length-1;
        while (low <= high){
            int j = partition(nums,low,high);
            if(j == nums.length-k){
                return nums[j];
            }else if(j < nums.length-k){
                low = j+1;
            }else {
                high = j-1;
            }
        }
        return -1;
    }
    
    public static int partition(int[] nums,int low,int high){
        int i = low;
        int j = low;
        int value = nums[high];
        for (;i<nums.length;i++){
            if(nums[i]<value){
                swap(nums,i,j);
                j++;
            }
        }
        swap(nums,j,high);
        return j;
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
