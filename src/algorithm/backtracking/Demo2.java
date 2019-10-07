package algorithm.backtracking;

/**
 * 0-1背包问题 能装W kg重量的书包，有n件不同的物品，重量不同，不可分割，书包最大可以装多少？
 */
public class Demo2 {


    private int maxCw = Integer.MIN_VALUE;
    /**
     * 主函数
     * @param i ：考察第几件物品
     * @param cw：现在物品的重量
     * @param items：每件物品重量的数组
     * @param n：一共多少件物品
     * @param w：书包能装重量
     */
    public void f(int i,int cw,int[] items,int n,int w){
        if(cw == w || i == n ){
            if(cw > maxCw) maxCw = cw;
            return;
        }
        f(i+1,cw,items,n,w);
        if(cw + items[i] < w){
            f(i+1,cw + items[i],items,n,w);
        }
    }
    public static void main(String[] args) {
        int cw = 0;
        int w = 80;
        int[] items = {70,15,15,45};
        Demo2 d = new Demo2();
        d.f(0,cw,items,4,w);
        System.out.println(d.maxCw);
    }
}
