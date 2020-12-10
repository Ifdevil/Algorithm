package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ele = new ArrayList<>();
        result.add(ele);
        if(nums == null || nums.length == 0){
            return result;
        }
        int len = nums.length;
        for (int i = 1;i<len+1;i++){
            int index = 0;
            while (index < len){
                ele = new ArrayList<>();
                for (int k = 0;k<i;k++){
                    int a = index;
                    boolean b = true;
                    for (int j = 0;j<i;j++){
                        if(a < len){
                            ele.add(nums[a]);
                            a+=(k+1);
                        }else {
                            b = false;
                            break;
                        }
                    }
                    if(b){
                        index++;
                        result.add(ele);
                    }else {
                        index++;
                    }
                }
            }
        }
        return result;
    }
}
