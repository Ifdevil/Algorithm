package leetcode1;

public class Solution5 {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0;l<n;l++){
            for (int i = 0;i+l<n;i++){
                int j = i+l;
                if(l == 0){
                    dp[i][j] = true;
                }else if(l == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }
                if(dp[i][j] && 1+l > ans.length()){
                    ans = s.substring(i,i+1+l);
                }
            }
        }
        return ans;
    }

    public static String longestPalindrome1(String s) {
        int n = s.length();
        int start = 0,end = 0;
        for (int i = 0;i<n;i++){
            // 中心扩展
            int a = expandAroundCenter(s,i,i);
            int b = expandAroundCenter(s,i,i+1);
            int len = Math.max(a,b);
            if(len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }
    
    public static int expandAroundCenter(String s,int left,int right){
        while(left >=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    
}
