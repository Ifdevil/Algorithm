package datastructure;

public class Demo1 {


    public static void main(String[] args) {

        int[] arr = {7,2,4,5,6,1};
        bubblesort(arr,arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d,",arr[i]);
        }
    }


    public static void bubblesort(int[] a,int n){
        int b = 0;
        boolean change = true;
        for (int i = n -1 ; i > 1 && change; i--) {
            change = false;
            System.out.println(++b+":"+i);
            for (int j = 0; j < i ; j++){
                if(a[j] > a[j+1]) {
                    int c = a[j];
                    a[j] = a[j+1];
                    a[j+1] = c;
                    change = true;
                }
            }
        }
    }
}
