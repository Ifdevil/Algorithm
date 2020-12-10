package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution54 {

    public static void main(String[] args) {
        int[][] matrix = {
                            { 1, 2, 3 },
                            { 4, 5, 6 },
                            { 7, 8, 9 }
                          };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(null == matrix || matrix.length==0 || matrix[0].length==0){
            return result;
        }
        int row = 0;
        int col = 0;
        int collen = matrix[0].length;
        int rowLen = matrix.length;

        int i = row;
        int j = col;
        while (row < rowLen && col<collen){
            while (j < collen){
                result.add(matrix[i][j]);
                j++;
            }
            row++;
            while (i < rowLen-1){
                result.add(matrix[i+1][j-1]);
                i++;
            }
            collen--;
            while (j > col && j-2>=0){
                result.add(matrix[i][j-2]);
                j--;
            }
            rowLen--;
            while (i > row && i-1>=0){
                result.add(matrix[i-1][j]);
                i--;
            }
            col++;
            
            i = row+1;
            j= col+1;
        }
        return result;
    }
}
