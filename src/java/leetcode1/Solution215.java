package leetcode1;

import java.util.Arrays;

public class Solution215 {

    public static void main(String[] args) {
        Solution215 S215 = new Solution215();
        int[] nums = {3,2,1,5,6,4,5,9};
        System.out.println(S215.findKthLargest(nums,2));
    }

    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        while (true){
            int partition = partition(low,high,nums);
            if(partition == nums.length - k){
                return nums[partition];
            }else if(partition > nums.length - k){
                high = partition - 1;
            }else {
                low = partition + 1;
            }
        }
    }
    
    public int partition(int low,int high,int[] nums){
        int value = nums[high];
        int i = low;
        for (int j = low;j<high;j++){
            if(nums[j] <= value){
                swap(i,j,nums);
                i++;
            }
        }
        swap(high,i,nums);
        return i;
    }
    
    public void swap(int i,int j,int[] nums){
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    /**
     * 第一种方法
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len-k];
    }
}
