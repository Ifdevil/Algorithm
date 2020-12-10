package exercise;

import java.util.Arrays;

public class Inteview {
    
    private static int[] person = new int[100];
    private static int size = 100;
    private static int start = 0;
    private static int j = 1;
    private static int count = 0;

    public static void main(String[] args) {
        Arrays.fill(person,1);
        test();
    }
    
    public static int test(){
        if(size == 1){
            return start;
        }
        for (int i = start;i<size;i+=j){
            if(count%2 == 1){
                person[i] = 0;
                size--;
            }
            count++;
        }
        count = 0;
        return test();
    }
}
