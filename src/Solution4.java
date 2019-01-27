import java.util.*;

public class Solution4 {

    public static void main(String[] args) {
        int[] num1 ={1,3};
        int[] num2 = {2};
//        double m = findMedianSortedArrays(num1,num2);
        double m = findMedianSortedArrays1(num1,num2);
        System.out.println(m);
    }

    /**
     * 暴力
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> set = new ArrayList<>();
        if(nums1!=null) {
            for (int i = 0; i < nums1.length; i++) {
                set.add(nums1[i]);
            }
        }
        if(nums2!=null) {
            for (int i = 0; i < nums2.length; i++) {
                set.add(nums2[i]);
            }
        }
        Collections.sort(set);
        Integer[] arr = set.toArray(new Integer[]{});
        int[] arry = new int[arr.length];
        for (int i=0;i < arr.length;i++){
            arry[i] = arr[i].intValue();
        }
        int n = arry.length;
        if(n%2==0){
            double c = ((double) (arry[n/2-1]+arry[n/2])/2);
            return c;
        }else {
            return (double) arry[n/2];
        }
    }

    /**
     * 递归  时间复杂度O（log(m+n))
     */
    public static double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
