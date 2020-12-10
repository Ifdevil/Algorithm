package leetcode;

/**
     * leetcode10 正则表达式匹配
 */
public class Leetcode10 {

    public static void main(String[] args) {
        String s = "aaaaaaa";
        String p = "a*";
        System.out.println(isMatch2(s,p));
    }

    /**
     * 回溯
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty() ;
        boolean first_match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if(p.length()>=2 && p.charAt(1) == '*'){
            //两种情况
            //1.* 号可以忽略
            //2.* 号不忽略，匹配串跳过第一个字符（匹配成功的情况下），进行下一轮匹配
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        }else {
            return first_match && isMatch(s.substring(1),p.substring(1));
        }
    }

    public static boolean isMatch2(String s,String p){
        memo = new Result[s.length()+1][p.length()+1];
        return dp(0,0,s,p);
    }
    /**
     * 动态规划算法
     */
    enum Result{
        TRUE,FALSE;
    }

    static Result[][] memo;
    static boolean ans = false;



    public static boolean dp(int i,int j,String s,String p){
        if(memo[i][j]!=null){
            return memo[i][j] == Result.TRUE;
        }
        if(j == p.length()){
            ans = i == s.length();
        }else {
            boolean first_match = i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if( j+1<p.length() && p.charAt(j+1) == '*'){
                ans = dp(i,j+2,s,p) || (first_match && dp(i+1,j,s,p));
            }else {
                ans = dp(i+1,j+1,s,p);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

}
