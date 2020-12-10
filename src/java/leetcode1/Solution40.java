package leetcode1;

import java.util.*;

public class Solution40 {

    public static void main(String[] args) {
        Solution40 s = new Solution40();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = s.combinationSum2(candidates, target);
        lists.forEach(x -> {
            x.forEach(System.out::print);
            System.out.println();
        });
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length==0){
            return result;
        }
        Arrays.sort(candidates);
        Stack<Integer> nums = new Stack<>();
        for (int i = 0;i<candidates.length;i++){
            if(candidates[i] <= target && (i== 0 || candidates[i-1] != candidates[i])){
                if(candidates[i] == target){
                    nums.add(candidates[i]);
                    result.add(new ArrayList<>(nums));
                    nums.pop();
                }else {
                    combine(candidates,i,target,result,0,nums);
                }
            }
        }
        return result;
    }
    
    public void combine(int[] candidates,int index,int target,List<List<Integer>> result,int sum,Stack<Integer> nums){
        int a = candidates[index];
        sum += a;
        nums.add(a);
        if(sum >= target){
            if(sum == target){
                result.add(new ArrayList<>(nums));
            }
            nums.pop();
            return;
        }
        for (int i = index+1;i<candidates.length;i++){
            if(i== index+1 || candidates[i-1] != candidates[i]) {
                combine(candidates, i, target, result, sum, nums);
            }
        }
        nums.pop();
    }
}
