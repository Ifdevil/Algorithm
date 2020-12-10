package leetcode1;

import java.util.*;

public class Solution46 {

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        System.out.println(Arrays.toString(solution46.permute(new int[]{1,2,3}).toArray()));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == nums || nums.length == 0){
            return result;
        }
        Deque<Integer> cur = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        all(nums,nums.length,0,result,cur,used);
        return result;
    }
    
    public void all(int[] nums, int len, int index, 
                    List<List<Integer>> result, 
                    Deque<Integer> cur,boolean[] used){
        if(index == len){
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0;i<len;i++){
            if(!used[i]){
                cur.addLast(nums[i]);
                used[i] = true;
                all(nums,len,index+1,result,cur,used);
                used[i] = false;
                cur.removeLast();
            }
        }
    }
}
