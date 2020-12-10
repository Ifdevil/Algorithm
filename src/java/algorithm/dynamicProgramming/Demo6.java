package algorithm.dynamicProgramming;

/**
 * 动态规划学习：背包问题演进
 * 
 * 对于一组不同重量、不可分割的物品,我们需要选择一些装入背包,
 * 在满足背包最大重量限制的前提下,背包中物品总重量的最大值是多少呢？
 */
public class Demo6 {
    
    private int maxW = Integer.MIN_VALUE;
    private int[] weight = {2,2,4,6,3};
    private int len = weight.length;
    private int w = 9; // 背包最大承受能力
    private boolean[][] mem = new boolean[len][w];

    public static void main(String[] args) {
        // 回溯
        Demo6 demo6 = new Demo6();
//        demo6.f(0,0);
        demo6.f1(0,0);
        System.out.println(demo6.maxW);
    }

    /**
     * 回溯算法
     * @param i
     * @param cw
     */
    public void f(int i,int cw){
        if(cw == w || i == len){
            maxW = Math.max(cw,maxW);
            return;
        }
        f(i+1,cw);
        if(cw + weight[i] <= w){
            f(i+1,cw+weight[i]);
        }
    }

    /**
     * 回溯算法 带备忘录
     * @param i
     * @param cw
     */
    public void f1(int i,int cw){
        if(cw == w || i == len){
            maxW = Math.max(cw,maxW);
            return;
        }
        if(mem[i][cw]) return;
        mem[i][cw] = true;
        f1(i+1,cw);
        if(cw + weight[i] <= w){
            f1(i+1,cw+weight[i]);
        }
    }
}
