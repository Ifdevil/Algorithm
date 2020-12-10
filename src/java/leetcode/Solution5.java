package leetcode;

public class Solution5 {

    public static void main(String[] args) {
//        String bb = longestPalindrome("ac");
//        System.out.println(bb);
        System.out.println(longestPalindrome2("balalab"));
    }

    /**
     * 暴力解决法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int a = 0;
        String longstr = "";
        for (int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                String str = s.substring(i,j+1);
                boolean ishuiwen = ishuiwen(str);
                if(ishuiwen) {
                    if(j+1-i-a>0){
                        a = j+1-i;
                        longstr = str;
                    }
                }
            }
        }
        return longstr;
    }

    public static String longestPalindrome2(String s) {
        int len = s.length();
        if(s == null || len == 0){
            return s;
        }
        String res = "";
        int max = 0;
        boolean[][] dp = new boolean[len][len];
        //这里只考虑了i<=j的情况，因为i>j时均为false
        //当i==j,j-i==1,j-i==2时，只要满足s.charAt(i) == s.charAt(j)就是回文字符串
        //如果不是这样，还要判断当前回文字符串的子串是不是回文字符串，即dp[i + 1][j - 1])，这就是动
        //态规划思想
        for(int j = 0; j < len; j++){
            for(int i = 0; i <= j; i++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if(dp[i][j]){//如果是回文字符串
                    if(j - i + 1 > max){//并且比之前的回文字符串要长，更新字符串长度，记录字符串
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    public static boolean ishuiwen(String s){
        int length = s.length();
         for (int i = 0; i < length / 2; i++) {
            if (s.toCharArray()[i] != s.toCharArray()[length - i - 1]) {
                 return false;
            }
         }
      return true;
    }
}
