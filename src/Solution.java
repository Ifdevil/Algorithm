import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] a = {3,3};
        int b = 6;
        System.out.println(Arrays.toString(twoSums(a,b)));
        System.out.println(Arrays.toString(a));
    }
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j = i+1; j<nums.length;j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoSums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int c = target - nums[i];
            System.out.println(c);
            if (map.containsKey(c) && map.get(c) != i) {
                return new int[] { i, map.get(c) };
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }


}
