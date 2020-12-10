package leetcode2;

public class Solution11 {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if(null == height || height.length == 0){
            return 0;
        }
        int low = 0;
        int high = height.length - 1;
        int area = 0;
        while (low < high){
            int lowH = height[low];
            int highH = height[high];
            area = Math.max(area,(high - low) * Math.min(lowH,highH));
            if(lowH < highH){
                low++;
            }else {
                high--;
            }
        }
        return area;
    }
}
