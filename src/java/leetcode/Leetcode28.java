package leetcode;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode28 {

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
//        System.out.println(haystack.charAt(3) == needle.charAt(0));
        System.out.println(strStr(haystack,needle));
     }

    public static int strStr(String haystack, String needle) {
        if(needle.length()== 0) return 0;
        int index = -1;
        int a = 0;
        for (int i = 0; i<haystack.length();i++){
            if(a<needle.length()){
                if(haystack.charAt(i) == needle.charAt(a)){
                    if(a == 0){
                        index = i;
                    }
                    a++;
                }else{
                    if(a > 0){
                        i = index;
                        a = 0;
                        index = -1;
                    }
                }
            }
        }
        return a == needle.length() ? index:-1;
    }
}