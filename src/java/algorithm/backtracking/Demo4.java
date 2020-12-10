package algorithm.backtracking;
/**
 * 背包问题：能装W kg重量的书包，有n件不同的物品，重量不同，不可分割，再引入物品价值这一变量，在满足最大重量的前提下，总价值最大
 */
public class Demo4 {

    private int maxVal = Integer.MIN_VALUE;

    private int[] items = {2,2,4,6,3};  // 物品的重量
    private int[] value = {3,4,8,9,6}; // 物品的价值
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量
    /**
     * 主函数
     * @param i ：考察第几件物品
     * @param cw：现在物品的重量
     * @param weight：每件物品重量的数组
     * @param n：一共多少件物品
     * @param w：书包能装重量
     */
    public void f(int i,int cw,int val,int[] weight,int[] value,int n,int w){
        if( cw == w || i == n){
            if(val > maxVal){
                maxVal = val;
            }
        }
        f(i+1,cw,val,weight,value,n,w);
        if(cw + weight[i] <= w){
            f(i+1,cw+weight[i],val+value[i],weight,value,n,w);
        }

    }
    public static void main(String[] args) {


    }
}
