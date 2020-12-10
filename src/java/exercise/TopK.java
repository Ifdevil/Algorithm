package exercise;

import java.util.Comparator;
import java.util.Random;

public class TopK {

    public static int[] toPrimitive(Integer array[]) {
        if (array == null)
            return null;
        if (array.length == 0)
            return new int[0];
        int result[] = new int[array.length];
        for (int i = 0; i < array.length; i++){
            result[i] = array[i].intValue();
        }
        return result;
    }

    public static int[] topK(int[] array, int n) {
        if (n >= array.length) {
            return array;
        }

        Integer[] topn = new Integer[n];
        for (int i = 0; i < topn.length; i++) {
            topn[i] = array[i];
        }

        Heap<Integer> heap = new Heap<Integer>(topn, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 生成最大堆使用o1-o2,生成最小堆使用o2-o1
                return o2 - o1;
            }
        });
        for (int i = n; i < array.length; i++) {
            int value = array[i];
            int min = heap.root();
            if (value > min) {
                heap.setRoot(value);
            }
        }
        return toPrimitive(topn);
    }

    public static void main(String[] args) {
        Random random = new Random(100);
        int[] array = new int[100];
        for(int i=0; i<100; i++){
            array[i] = random.nextInt(1000);
        }
        int count = 0;
        for(int i=0; i<100; i++){
            count++;
            System.out.print(array[i] + " ");
            if(count >= 25){
                System.out.println();
                count=0;
            }
        }
        System.out.print("Top 10 :");
        int[] result = topK(array, 10);
        for (int integer : result) {
            System.out.print(integer + ",");
        }
    }

}