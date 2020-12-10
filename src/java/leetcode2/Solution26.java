package leetcode2;

public class Solution26 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int p1 = 0;
        int p2 = 1;
        for (;p2 < nums.length;p2++){
            if(nums[p2] != nums[p1]){
                swap(nums,++p1,p2);
            }
        }
        return p1+1;
    }
    
    private static void swap(int[] nums,int p1,int p2){
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
