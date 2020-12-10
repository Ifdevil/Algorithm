package leetcode2;

public class Solution10 {

    public static void main(String[] args) {
        System.out.println(isMatch1("aa","aa"));
    }

    public static boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        boolean first_match = !s.isEmpty() &&  (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if(p.length() >= 2 && p.charAt(1) == '*'){
            return  (isMatch(s,p.substring(2)) || 
                    (first_match && isMatch(s.substring(1),p)));
        }else {
            return first_match && isMatch(s.substring(1),p.substring(1));
        }
    }

    public static boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
                else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }
    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
