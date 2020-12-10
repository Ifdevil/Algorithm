package leetcode1;

public class Solution11 {


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while (left<right){
            int minHeight = Math.min(height[left],height[right]);
            maxArea = Math.max((right-left)*minHeight,maxArea);
            if(height[left] > height[right]){
                right--;
            }else if(height[right] >= height[left]){
                left++;
            }
        }
        return maxArea;
    }
}
