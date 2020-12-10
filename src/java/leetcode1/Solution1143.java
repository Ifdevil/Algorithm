package leetcode1;

public class Solution1143 {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("aac","ac"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if(null == text1 || null == text2 || text1.length()== 0 || text2.length() == 0){
            return 0;
        }
        int n = text1.length();
        int m = text2.length();
        int max = 0;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0;i<m+1;i++){
            dp[0][i] = 0;
        }
        for (int i = 0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for (int i = 1;i < n+1;i++){
            for (int j = 1;j < m+1;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                max = Math.max(dp[i][j],max);
            }
        }
        return max;
    }
}
