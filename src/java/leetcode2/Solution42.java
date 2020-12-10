package leetcode2;

import java.util.Deque;
import java.util.LinkedList;

public class Solution42 {

    public static void main(String[] args) {
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {3,0,1,0,2,0,5};
        System.out.println(trap3(height));
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length;
        while (height[left] <= 0){
            left++;
        }
        while (height[right-1] == 0){
            right--;
        }
        int area = 0;
        for (int i = left;i<right;i++){
            
        }
        return area;
    }

    public static int trap1(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            // 当前元素左边最大值
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            // 当前元素右边最大值
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            // 当前元素能收集的水
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    public static int trap2(int[] height) {
        if(height == null || height.length==0){
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1;i<size;i++){
            left_max[i] = Math.max(height[i],left_max[i-1]);
        }
        right_max[size-1] = height[size-1];
        for (int i = size-2;i>=0;i--){
            right_max[i] = Math.max(height[i],right_max[i+1]);
        }
        for (int i = 1;i<size-1;i++){
            ans += Math.min(left_max[i],right_max[i])-height[i];
        }
        return ans;
    }

    public static int trap3(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }
}
