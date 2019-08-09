/**
 * leetcode10 正则表达式匹配
 */
public class Leetcode10 {

    public static void main(String[] args) {
        String s = "aba";
        String p = "a*aaa";
        System.out.println(isMatch(s,p));
    }

    /**
     * 回溯
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if(s.isEmpty()) return p.isEmpty() ;
        boolean first_match = !p.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if(p.length()>2 && p.charAt(1) == '*'){
            //两种情况
            //1.* 号可以忽略
            //2.* 号不忽略，匹配串跳过第一个字符（匹配成功的情况下），进行下一轮匹配
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        }else {
            return first_match && isMatch(s.substring(1),p.substring(1));
        }
    }

}
