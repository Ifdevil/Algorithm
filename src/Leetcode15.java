import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class Leetcode15 {

    public static void main(String[] args) {
        int[] test = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSum(test);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j)+",");

            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        // 循环遍历nums
        for (int k = 0; k < nums.length - 2; k++) {
            if(nums[k] > 0){
                break;
            }
            if(k > 0 && nums[k] == nums[k-1]){
                continue;
            }
            int i = k+1;
            int j = nums.length-1;
            while (i<j){
                int s = nums[k] + nums[i] + nums[j];
                if(s < 0) i++;
                if(s > 0) j--;
                if(s == 0){
                    list.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }

        }
        return list;
    }
}
