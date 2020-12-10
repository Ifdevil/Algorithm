package algorithm.sort;

import java.util.Arrays;

public class InsertSort1 {

    public static void main(String[] args) {
        int[] nums = {2,1,3,2,5,6,1,7,9,8};
        insert(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public static void insert(int[] nums){
        for (int i = 1;i<nums.length;i++){
            int j = nums[i];
            int t = i-1;
            while (t >=0 && nums[t]>j){
                nums[t+1] = nums[t];
                t--;
            }
            nums[t+1] = j;
        }
    }
}
