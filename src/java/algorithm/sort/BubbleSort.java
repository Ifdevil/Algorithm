package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {2,1,3,2,5,6,1,7,9,8};
        System.out.println(Arrays.toString(bubble(nums)));
    }

    public static int[] bubble(int[] nums){
        if(nums.length<2) return nums;
        for (int i = 0;i<nums.length-1;i++){
            boolean flag = false;
            for (int j = 0;j<nums.length - i -1;j++){
                if(nums[j+1]<nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) return nums;
        }
        return nums;
    }
}
