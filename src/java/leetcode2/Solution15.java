package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0;i<nums.length-2;i++){
            int a = nums[i];
            if(i !=0 && a == nums[i-1]){
                continue;
            }else {
                int low = i+1;
                int high = nums.length-1;
                while (low < high){
                    int sum = nums[i]+nums[low]+nums[high];
                    if(sum == 0){
                        res.add(new ArrayList<>(Arrays.asList(nums[a], nums[low], nums[high])));
                        low++;
                        high--;
                        while (high > low && nums[low] == nums[low-1]){low++;};
                        while (high > low && nums[high] == nums[high+1]){high--;};
                    }else if(sum > 0){
                        high--;
                    }else {
                        low++;
                    }
                }
            }
        }
        return res;
    }
    
}
