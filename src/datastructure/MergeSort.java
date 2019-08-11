package datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {2,1,3100,456,21,0,5,6,8,3,78,9999,10};
        mergesort(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void mergesort(int[] a,int low,int high){

        int mid = (low+high)/2;
        if (low<high){
            mergesort(a,low,mid);
            mergesort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }

    public static void merge(int[] a,int low,int mid,int high){
        List list = new ArrayList<Integer>(a.length);
        int i;
        int j;
        int k;
        for (i = low,j = mid+1,k = 0;i<=mid && j<=high;k++){
            if(a[i]>a[j]){
                list.add(a[j]);
                j++;
            }else{
                list.add(a[i]);
                i++;
            }
        }
        while (i<=mid){
            list.add(a[i++]);
        }
        while (j<=high){
            list.add(a[j++]);
        }

        for (int l = 0; l < list.size(); l++) {
            a[low++] = (int) list.get(l);
        }
    }
}
