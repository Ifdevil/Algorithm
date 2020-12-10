package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class barrageSolution {


    public static void main(String[] args) {
        int[] f = new int[110];
        boolean[] boundHash = new boolean[110];
        int n;
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(f, 0);
        Arrays.fill(boundHash, false);
        n = scanner.nextInt();
        while (n-- != 0) {
            int a, b;
            a = scanner.nextInt();
            b = scanner.nextInt();
            boundHash[a] = true;
            boundHash[b] = true;
            for (int i = a + 1; i <= b; i++) f[i]++;
        }
        int max = 0;
        for (int i = 0; i < 100; i++) {
            if (f[i] > max) {
                max = f[i];
            }
        }
        int left, right;
        for (int i = 1; i < 100; i++) {
            if (f[i] == max) {
                left = i - 1;
                int j = i;
                while (f[j] == max && !boundHash[j]) {
                    j++;
                }
                right = j;
                System.out.printf("%d %d\n", left, right);
                i = j;
            }
        }
    }


    public static void barrage(){
        int[] f = new int[110];
        Arrays.fill(f,0);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n--!=0){
            int a,b;
            a = scanner.nextInt();
            b = scanner.nextInt();
            for (int i=a+1;i<=b;i++) f[i]++;
        }
        int max = 0;
        for (int i = 0; i < 100; i++) {
            if(f[i]>max){
                max = f[i];
            }
        }
        int left,right;
        for (int i = 0; i < 100; i++) {
            if(f[i] == max){
                left = i-1;
                int j = i;
                while (f[j] == max){
                    j++;
                }
                right = j;
                System.out.printf("%d %d\n",left,right);
                i = j;
            }
        }
    }
}
