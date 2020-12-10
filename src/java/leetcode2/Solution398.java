package leetcode2;

import java.util.Random;

public class Solution398 {

    public static void main(String[] args) {
        
    }

    int[] nums;
    
    public Solution398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random r = new Random();
        int index = 0;
        int count = 0;
        for (int i = 0;i<nums.length;i++){
            if(nums[i] == target){
                count++;
                if(r.nextInt() % count == 0) index = i;
            }
        }
        return index;
    }
}
