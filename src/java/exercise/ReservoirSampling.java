package exercise;

import java.util.Random;

public class ReservoirSampling {

    private static int[] pool; // 所有数据
    private static final int N = 10; // 数据规模
    private static Random random = new Random();
    
    public static void main(String[] args) throws Exception {
        setUp();
        for (int i : sampling(6)) {
            System.out.println(i);
        }
    }

    public static void setUp() throws Exception {
        // 初始化
        pool = new int[N];
        for (int i = 0; i < N; i++) {
            pool[i] = i;
        }
    }

    private static int[] sampling(int K) {
        int[] result = new int[K];
        for (int i = 0; i < K; i++) { // 前 K 个元素直接放入数组中
            result[i] = pool[i];
        }
        for (int i = K; i < N; i++) { // K + 1 个元素开始进行概率采样
            int r = random.nextInt(i + 1);
            if (r < K) {
                result[r] = pool[i];
            }
        }
        return result;
    }
    
    
}
