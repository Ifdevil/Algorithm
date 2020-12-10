package leetcode2;

import java.util.Arrays;

public class Solution16 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(threeSumClosest(nums,100));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 10001;
        for (int f = 0; f<nums.length-2; f++){
            int s = f+1;
            int t = nums.length-1;
            while (s < t){
                int add = nums[f]+nums[s]+nums[t];
                if(add == target){
                    return target;
                }else {
                    if(Math.abs(add-target) < Math.abs(sum-target)){
                        sum = add;
                    }
                    if(add > target){
                        t--;
                    }else {
                        s++;
                    }
                }
            }
        }
        return sum;
    }
}
