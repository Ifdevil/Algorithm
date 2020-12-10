package algorithm.dynamicProgramming;

/**
 * 背包问题：能装W kg重量的书包，有n件不同的物品，重量不同，不可分割，书包最大可以装多少？
 *        1.回溯算法，重复计算
 *        2.动态规划
 */
public class Demo1 {


    /**
     * 动态规划：使用一维数组实现
     * @param items
     * @param n
     * @param w
     * @return
     */
    public static int f2(int[] items, int n, int w) {
        int count = 0;
        boolean[] states = new boolean[w+1]; // 默认值 false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (items[0] <= w) {
            states[items[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划
            // 这里注意：这里需要从大到小，否则出现for循环重复计算，导致结果集不同
            for (int j = w-items[i]; j >= 0; j--) {// 把第 i 个物品放入背包
                if (states[j]==true) {
                    states[j+items[i]] = true;

                }
            }
        }

        for (int i = w; i >= 0; --i) { // 输出结果
            if(states[i] == true) return i;
        }
        System.out.println("count:"+count);

        return 0;
    }


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

    /**
     * 近似动态规划
     * @param i ：考察第几件物品
     * @param cw：现在物品的重量
     * @param items：每件物品重量的数组
     * @param n：一共多少件物品
     * @param w：书包能装重量
     */
    public void f(int i,int cw,int[] items,int n,int w){
        boolean[][] mem = new boolean[n][w+1];// w:0~w 中背包重量状态
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
        int w = 10;
        int[] items = {4,5,9};
        Demo1 d = new Demo1();
//        d.f(0,cw,items,10,w);
//        System.out.println(d.maxCw);

        System.out.println(d.f2(items,3,w));
    }
}
