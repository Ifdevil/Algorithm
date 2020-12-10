package leetcode2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum1(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        if(null == nums || nums.length == 0){
            return null;
        }
        int[] result = new int[2];
        int r1 = 0;
        for (;r1<nums.length;r1++){
            for (int r2 = r1+1;r2<nums.length;r2++){
                if(nums[r1] + nums[r2] == target){
                    result[0] = r1;
                    result[1] = r2;
                }
            }
        }
        return result;
    }

    public static int[] twoSum1(int[] nums, int target) {
        if(null == nums || nums.length == 0){
            return null;
        }
        Map<Integer,Integer> table = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            if(table.containsKey(target- nums[i])){
                return new int[]{table.get(target-nums[i]),i};
            }
            table.put(nums[i],i);
        }
        return null;
    }
}
