package algorithm.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {2,1,3,2,5,6,1,7,9,8};
        System.out.println(Arrays.toString(insert(nums)));
    }

    public static int[] insert(int[] nums){
        if(nums.length<2) return nums;
        int len = nums.length;
        for (int i = 1;i<len;i++){
            int value = nums[i];
            int j = i - 1;
            for (;j>=0;j--){
                if(nums[j] > value){
                    nums[j+1] = nums[j];
                }else {
                    break;
                }
            }
            nums[j+1] = value;
        }
        return nums;
    }
}
