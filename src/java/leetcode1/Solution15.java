package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if(len < 3){
            return result;
        }
        Arrays.sort(nums);
        for (int a = 0;a<nums.length - 2;a++){
            if(nums[a]>0) break;
            if(a >0 && nums[a] == nums[a-1])continue;
            int target = -nums[a];
            int b = a+1;
            int c = nums.length - 1;
            while (b < c){
                if(nums[b] + nums[c] == target){
                    result.add(new ArrayList<>(Arrays.asList(nums[a], nums[b], nums[c])));
                    b++;
                    c--;
                    while (b < c && nums[b] == nums[b-1]) b++;
                    while (b < c && nums[c] == nums[c+1]) c--;
                }else if(nums[b] + nums[c]<target){
                    b++;
                }else {
                    c--;
                }
            }
        }
        return result;
    }
}
