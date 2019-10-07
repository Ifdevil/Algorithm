package algorithm.backtracking;

/**
 * 8皇后问题
 */
public class Demo1 {

    int[] result = new int[8];
    int count = 0;
    public void cal8queues(int row){
        if(row == 8){
            printQueue();
            count++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if(isOk(row,i)){
                result[row] = i;
                cal8queues(row+1);
            }
        }

    }

    public boolean isOk(int row,int column){
        int left = column-1;
        int right = column+1;
        for (int i = row-1; i >=0 ; i--) {
            if(result[i] == column) return false;
            if(result[i] == left || result[i] == right){
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
    public void printQueue(){
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Demo1 d = new Demo1();
        d.cal8queues(0);
        System.out.println(d.count);
    }
}
