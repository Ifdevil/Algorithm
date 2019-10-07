package algorithm.backtracking;

/**
 * 正则表达式
 */
public class Demo3 {

    public static void main(String[] args) {
        char[] pattern = {'*','2','?','1'};
        Pattern p = new Pattern(pattern,4);
        char[] test = {'1','2','2','3','2','1'};
        p.match(test,6);
        System.out.println(p.matched);
    }
}
class Pattern{

    boolean matched = false;
    private char[] pattern; // 正则表达式
    private int plen; // 正则表达式长度

    public Pattern(char[] pattern,int plen){
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text,int tlen){
        matched = false;
        rmatch(0,0,text,tlen);
        return matched;
    }

    private void rmatch(int ti,int pj,char[] text,int tlen){
        if(matched) return;
        if(pj == plen){
            if(ti == tlen){
                matched = true;
                return;
            }
        }
        if(pattern[pj] == '*'){
            for (int i = ti; i < tlen-ti; i++) {
                rmatch(i,pj+1,text,tlen);
            }
        }else if(pattern[pj] == '?'){
            rmatch(ti+1,pj+1,text,tlen);
            rmatch(ti,pj+1,text,tlen);
        }else if(ti < tlen && pattern[pj] == text[ti]){
            rmatch(ti+1,pj+1,text,tlen);
        }
    }
}
