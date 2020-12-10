package leetcode1;

public class Solution62 {

    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        System.out.println(solution62.uniquePaths1(10,9));
        System.out.println(solution62.uniquePaths(10,9));
    }

    /**
     * 回溯
     * @param m
     * @param n
     * @return
     */
    private int num = 0;
    public int uniquePaths(int m, int n) {
        path(1,1,m,n);
        return num;
    }
    
    public void path(int row,int col,int m,int n){
        if(row == n && col == m){
            num++;
            return;
        }
        if(row < n){
            path(row+1,col,m,n);
        }
        if(col < m){
            path(row,col+1,m,n);
        }
    }

    /**
     * 动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0;i<m;i++){
            dp[i][0] = 1;
        }
        for (int i = 0;i<n;i++){
            dp[0][i] = 1;
        }
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
