package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {

    public static void main(String[] args) {
        
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return arr;
        }
        int left = 0;
        int up = 0;
        int right = matrix[0].length-1;
        int down = matrix.length-1;
        while (up < down && left < right){
            for (int i = left;i<matrix[up].length;i++){
                arr.add(matrix[up][i]);
            }
            for (int i = up + 1;i<down;i++){
                arr.add(matrix[i][right]);
            }
            if(up < down-1 && left < right-1){
                for (int i = right-2;i>=left;i--){
                    arr.add(matrix[down][i]);
                }
                for (int i = down-1;i>up;i--){
                    arr.add(matrix[i][left]);
                }
            }
            up++;
            down--;
            left++;
            right--;
        }
        return arr;
    }
}
