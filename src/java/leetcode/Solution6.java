package leetcode;

/**
 * 最长回文
 */
public class Solution6 {

    public static void main(String[] args) {
        String str = "abbcbddbca";
        System.out.println(method2(str));
    }


    /**
     * 动态规划 dp
     * @param str
     * @return
     */
    public static String method2(String str) {
        int length = str.length();
        boolean[][] lps = new boolean[length][length];
        char[] chars = str.toCharArray();
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j < 2) {
                    lps[j][i] = chars[i] == chars[j];
                } else {
                    // 如果 [i, j] 是回文子串，那么一定有 [j+1, i-1] 也是回子串
                    lps[j][i] = lps[j + 1][i - 1] && (chars[i] == chars[j]);
                }
                if (lps[j][i] && (i - j + 1) > maxLen) {
                    // 如果 [i, j] 是回文子串，并且长度大于 max，则刷新最长回文子串
                    maxLen = i - j + 1;
                    start = j;
                }
            }

        }
        return str.substring(start, start + maxLen);
    }
    /**
     * 中心扩展法
     * @param str
     * @return
     */
    public static String method1(String str){
        int start = 0;
        int end = 0;
        if(str == null || str.length()==0){
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            int len1 = expendAroundCenter(str,i,i);
            int len2 = expendAroundCenter(str,i,i+1);
            int len = Math.max(len1,len2);
            if (len>end-start){
                start = i-(len-1)/2;
                end = i+(len/2);
            }
        }
        return str.substring(start,end+1);
    }
    public static int expendAroundCenter(String s,int i,int j){
        int L = i;int R = j;
        while (L>=0 && R<s.length() && s.charAt(L)== s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}
