package exercise;

import java.util.Random;

public class RandomSelect {
    
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        for (int i = 0;i<nums.length;i++){
            System.out.println(select(nums,nums.length-i));
        }
    }

    /* 洗牌算法：
    1.生成一个0 - arr.length 的随机数
    2.交换该随机数位置元素和数组的最后一个元素，并把该随机位置的元素放入结果数组
    3.生成一个0 - arr.length - 1 的随机数
    4.交换该随机数位置元素和数组的倒数第二个元素，并把该随机位置的元素放入结果数组
    依次类推，直至取完所需的10k个元素
*/
    public static int select(int[] nums,int size){
        Random random = new Random();    
        int randomIndex = random.nextInt(size);
        int result = nums[randomIndex];
        nums[randomIndex] = nums[size-1];
        nums[size-1] = result;
        return result;
    }
}
