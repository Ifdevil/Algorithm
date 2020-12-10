package leetcode1;

public class Solution64 {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        if(null == grid || grid[0].length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] result = new int[row][col];
        for (int i = 0;i<row;i++){
            for (int j = 0;j<col;j++){
                if(i == 0 && j ==0){
                    result[i][j] = grid[0][0];
                }else if(i == 0){
                    result[i][j] = result[i][j-1]+grid[i][j];
                }else if(j == 0){
                    result[i][j] = result[i-1][j]+grid[i][j];
                }else {
                    result[i][j] = Math.min(result[i-1][j],result[i][j-1])+grid[i][j];
                }
            }
        }
        return result[row-1][col-1];
    }
}
