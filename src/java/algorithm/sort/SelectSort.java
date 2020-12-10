package algorithm.sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] nums = {2,1,3,2,5,6,1,7,9,8};
        select(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public static void select(int[] nums){
        int min = 0;
        for (int i = 0;i<nums.length;i++){
            min = i;
            for (int j=i;j<nums.length;j++){
                if(nums[j]<nums[min]){
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }
}
