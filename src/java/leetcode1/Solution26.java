package leetcode1;

public class Solution26 {

    public static void main(String[] args) {
        
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int written = 0;
        for (int i = 1;i<len;i++){
            if(nums[i] != nums[written]){
                written++;
                nums[written] = nums[i];
            }
        }
        return written+1;
    }
}
