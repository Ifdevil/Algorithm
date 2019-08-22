import java.util.Arrays;

public class Leetcode16 {


    public static void main(String[] args) {
        int[] nums = {1,1,-1,-1,3};
        System.out.println(threeSumClosest(nums,-1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int min = nums[0]+nums[1]+nums[2];
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k+1;
            int j = nums.length-1;
            while (i<j){
                int sum = nums[k] + nums[i] + nums[j];
                if(Math.abs(target - sum) < Math.abs(target - min))
                    min = sum;
                if(sum > target)
                    j--;
                else if(sum < target)
                    i++;
                else
                    return min;

            }
        }
        return min;
    }

}
