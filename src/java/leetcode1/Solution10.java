package leetcode1;

public class Solution10 {

    public static void main(String[] args) {
        Solution10 s10 = new Solution10();
        System.out.println(s10.isMatch("aab","c*a*b"));
    }

    public boolean matched = false;
    public boolean isMatch(String s, String p) {
        match(0,0,s,p);
        return matched;
    }
    
    public void match(int sIndex,int pIndex,String s,String p){
        if(matched) return;
        if(pIndex > p.length()){
            return;
        }
        if(pIndex == p.length()){
            if(sIndex == s.length()){
                matched = true;
                return;
            }else {
                return;
            }
        }
        if(p.charAt(pIndex) == '*'){
            match(sIndex,pIndex+1,s,p);
            int k = 1;
            while (k < s.length()){
                if(s.charAt(sIndex) == p.charAt(pIndex-1) || p.charAt(pIndex-1) == '.'){
                    match(sIndex+k,pIndex+1,s,p);
                    k++;
                }
            }
        }else if(p.charAt(pIndex) == '.'){
            match(sIndex+1,pIndex+1,s,p);
        }else if(sIndex < s.length() && s.charAt(sIndex) == p.charAt(pIndex)){
            match(sIndex+1,pIndex+1,s,p);
        }else if(pIndex+1 < p.length() && p.charAt(pIndex+1) == '*'){
            match(sIndex,pIndex+2,s,p);
        }
    }

    public static boolean isMatch1(String s, String p) {
        if(p.isEmpty()) return s.isEmpty() ;
        boolean first_match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if(p.length()>=2 && p.charAt(1) == '*'){
            //两种情况
            //1.* 号可以忽略
            //2.* 号不忽略，匹配串跳过第一个字符（匹配成功的情况下），进行下一轮匹配
            return (isMatch1(s, p.substring(2)) ||
                    (first_match && isMatch1(s.substring(1), p)));
        }else {
            return first_match && isMatch1(s.substring(1),p.substring(1));
        }
    }
}
