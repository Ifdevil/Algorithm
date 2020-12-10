package leetcode1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution384 {
    
    private int[] nums;
    List<List<Integer>> all = new ArrayList<>();

    public Solution384(int[] nums){
        this.nums = nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution384 s = new Solution384(nums);
        s.all();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        int[] res = new int[this.nums.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = this.nums[i];
        }
        for(int i = res.length - 1; i >= 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = res[index];
            res[index] = res[i];
            res[i] = temp;
        }
        return res;
    }
    
    public void all(){
        sort(0,new ArrayList<>());
    }
    
    public void sort(int i,List<Integer> ele){
        if(i == nums.length){
            all.add(ele);
            ele.remove(i-1);
            return;
        }
        for (;i<nums.length;i++){
            ele.add(nums[i]);
            sort(i+1,ele);
            ele.remove(i-1);
        }
    }
}
