package leetcode1;

import java.util.*;

public class Solution945 {

    public static void main(String[] args) {
        int[] A = {1,1,2,0};
        System.out.println(minIncrementForUnique1(A));
    }

    public static int minIncrementForUnique(int[] A) {
        if(null == A || A.length == 0){
            return 0;
        }
        Arrays.sort(A);
        Set<Integer> num = new HashSet<>();
        num.add(A[0]);
        int count = 0;
        for (int i = 1;i<A.length;i++){
            if (num.contains(A[i])){
                int v = A[i-1];
                count += Math.abs(v-A[i]+1);
                A[i] = v+1;
            }
            num.add(A[i]);
        }
        return count;
    }

    public static int minIncrementForUnique2(int[] A) {
        if(null == A || A.length == 0){
            return 0;
        }
        Arrays.sort(A);
        int count = 0;
        for (int i = 1;i<A.length;i++){
            if(A[i] <= A[i-1]){
                int v = A[i-1];
                count += v-A[i]+1;
                A[i] = v+1;
            }
        }
        return count;
    }

    public static int minIncrementForUnique1(int[] A) {
        int len = A.length;
        if(len <=1) return 0;

        int max = -1;
        for(int i= 0; i< len; i++) {
            if(A[i] > max) max = A[i];
        }

        int[] cnt = new int[max+2];
        for(int i = 0; i<len; i++) {
            cnt[A[i]]++;
        }

        int counter = 0;
        for(int j = 0; j<max+1; j++) {
            if(cnt[j] >1) {
                int d = cnt[j] - 1;
                counter += d;
                cnt[j+1] += d;
            }
        }
        int d = cnt[max+1] - 1;
        counter += d*(d+1)/2;
        return counter;
    }
}
