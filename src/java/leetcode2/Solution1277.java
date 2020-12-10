package leetcode2;

public class Solution1277 {

    public static void main(String[] args) {
        int[][] matrix = {
                            {0,1,1,1},
                            {1,1,1,1},
                            {0,1,1,1}
                          };
        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0;i<m;i++){
            ans += dp[i][0] = matrix[i][0];
        }
        for (int i = 0;i<n;i++){
            ans += dp[0][i] = matrix[0][i];
        }
        if (matrix[0][0] == 1) {
            ans--;
        }
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    ans+=dp[i][j];
                }
            }
        }
        return ans;
    }
}
