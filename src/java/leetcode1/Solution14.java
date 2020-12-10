package leetcode1;

public class Solution14 {


    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String common = "";
        if(strs.length == 0)return common;
        common = strs[0];
        for(int i = 1;i<strs.length;i++){
            int len = Math.min(common.length(),strs[i].length());
            String a = "";
            for (int j = 0;j<len;j++){
                if(common.charAt(j) == strs[i].charAt(j)){
                    a+=strs[i].charAt(j);
                }else {
                    break;
                }
            }
            if(a.length() == 0){
                return a;
            }
            common = a;
            
        }
        return common;
    }

    /**
     * 把字符串拼接改成下标，时间从20ms提升到1ms
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        String common = "";
        if(strs.length == 0)return common;
        common = strs[0];
        for(int i = 1;i<strs.length;i++){
            int len = Math.min(common.length(),strs[i].length());
            int a = 0;
            for (int j = 0;j<len;j++){
                if(common.charAt(j) == strs[i].charAt(j)){
                    a++;
                }else {
                    break;
                }
            }
            if(a == 0){
                return "";
            }
            common = common.substring(0,a);

        }
        return common;
    }
    
}
