package leetcode2;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {

    static List<Integer> t = new ArrayList<>();
    static List<List<Integer>> result = new ArrayList<>();
    
    
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return result;
    }

    public static void dfs(int cur,int[] nums){
        if(cur == nums.length){
            result.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur+1,nums);
        t.remove(t.size()-1);
        dfs(cur+1,nums);
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(1 << nums.length);
        //先添加一个空的集合
        res.add(new ArrayList<>());
        for (int num : nums) {
            //每遍历一个元素就在之前子集中的每个集合追加这个元素，让他变成新的子集
            for (int i = 0, j = res.size(); i < j; i++) {
                //遍历之前的子集，重新封装成一个新的子集
                List<Integer> list = new ArrayList<>(res.get(i));
                //然后在新的子集后面追加这个元素
                list.add(num);
                //把这个新的子集添加到集合中
                res.add(list);
            }
        }
        return res;
    }
}
