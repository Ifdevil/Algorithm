/**
 * 11. 盛最多水的容器
 */
public class Leetcode11 {


    public static void main(String[] args) {
        int[] a = {2,3,4,5,18,17,6};
        System.out.println(maxArea2(a));

    }


    public static int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

    public static int maxArea2(int[] height) {
        int maxarea = 0,l=0,r=height.length-1;
        while (r>l){
            maxarea = Math.max(maxarea,Math.min(height[l],height[r])*(r-l));
            if(height[l]>height[r]){
                r--;
            }else {
                l++;
            }
        }
        return maxarea;
    }
}
