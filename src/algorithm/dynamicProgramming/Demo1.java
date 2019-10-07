package algorithm.dynamicProgramming;

/**
 * 背包问题
 *        1.回溯算法，重复计算
 *        2.动态规划
 */
public class Demo1 {


    /**
     * 动态规划
     * @param weight
     * @param n
     * @param w
     * @return
     */
    public int f1(int[] weight,int n,int w){
        boolean[][] states = new boolean[n][w+1];
        states[0][0] = true;
        if(weight[0] < w){
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; i++) { //动态规划状态转移
            for (int j = 0; j <= w; j++) { // 第i件物品不放进书包
                if(states[i-1][j] == true) states[i][j] = true;
            }
            for (int j = 0; j <= w-weight[i]; j++) { // 第i件物品放进书包
                if(states[i-1][j] == true) states[i][j+weight[i]] = true;
            }

        }
        for (int i = w; i >= 0; i--) {
            if(states[n-1][i] == true) return i;
        }
        return 0;
    }


    private int maxCw = Integer.MIN_VALUE;
    boolean[][] mem = new boolean[10][81];// 5:只有5件物品  81：0~80 中背包重量状态

    /**
     * 近似动态规划
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
        if(mem[i][cw]) return;
        mem[i][cw] = true;
        f(i+1,cw,items,n,w);
        if(cw + items[i] <= w){
            f(i+1,cw + items[i],items,n,w);
        }
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int cw = 0;
        int w = 80;
        int[] items = {70,15,15,45,2,8,9,10,12,40};
        Demo1 d = new Demo1();
        d.f(0,cw,items,10,w);
        System.out.println(d.maxCw);

        System.out.println(d.f1(items,10,w));
    }
}
