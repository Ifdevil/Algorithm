package algorithm.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortDemo {

    public static void main(String[] args) {
        int[] list1=new int[]{1,2,8,9,2,3};
        int[] list2=new int[]{2,3,1,3,8,5,4};
        Object[] res = getRes(list1, list2);
        for(Object o:res){
            System.out.print(o+" ");
        }
    }

    public static Object[] getRes(int[] list1, int[] list2){
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i<list1.length){
            set.add(list1[i]);
            i++;
        }
        i = 0;
        while (i<list2.length){
            set.add(list2[i]);
            i++;
        }
        Object[] b = set.toArray();
        return b;
    }
}
