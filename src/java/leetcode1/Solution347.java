package leetcode1;

import java.util.*;

public class Solution347 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0;i<nums.length;i++){
            int key = nums[i];
            map.put(key,map.getOrDefault(key,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int[] result = new int[k];
        for (int i = 0;i<k;i++){
            result[i] = list.get(i).getKey();
        }
        return result;
    }
}
