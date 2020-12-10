package algorithm.sort;

import java.util.Arrays;

public class BubbleSort1 {

    public static void main(String[] args) {
        int[] nums = {2,1,3,2,5,6,1,7,9,8};
        bubble(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public static void bubble(int[] nums){
        for (int i = 0;i<nums.length-1;i++){
            for (int j = 0;j<nums.length-i-1;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
