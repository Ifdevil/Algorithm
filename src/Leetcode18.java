import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 */
public class Leetcode18 {


    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> list = fourSum(nums,target);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j)+",");

            }
            System.out.println();
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;
            for (int j = i+1; j < nums.length-2; j++) {
                if (j - i > 1 && nums[j] == nums[j - 1]) continue;
                int a = j+1;
                int b = nums.length-1;
                while (a<b){
                    int result = nums[i]+nums[j]+nums[a]+nums[b];
                    if(result>target){
                        b--;
                    }
                    if(result<target){
                        a++;
                    }
                    if(result == target){
                        List<Integer> ele = new ArrayList<Integer>();
                        ele.add(nums[i]);
                        ele.add(nums[j]);
                        ele.add(nums[a]);
                        ele.add(nums[b]);
                        list.add(ele);
                        while (nums[a] == nums[++a] && a<b) ;
                        while (nums[b] == nums[--b] && b>a) ;
                    }
                }
            }
        }
        return list;
    }


}
