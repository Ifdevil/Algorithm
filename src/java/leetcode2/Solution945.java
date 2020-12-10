package leetcode2;

public class Solution945 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(nums));
    }

    public static int minIncrementForUnique(int[] A) {
        int[] count = new int[80000];
        for (int x:A){
            count[x]++;
        }
        int ans = 0;
        int taken = 0;
        for(int x = 0;x<80000;x++){
            if(count[x] >= 2){
                taken += (count[x]-1);
                ans -= x * (count[x] -1);
            }else if(taken > 0 && count[x]==0){
                taken--;
                ans += x;
            }
        }
        return ans;
    }
}
